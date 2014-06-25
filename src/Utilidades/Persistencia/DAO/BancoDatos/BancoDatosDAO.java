/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades.Persistencia.DAO.BancoDatos;

import Utilidades.Inventario.ArbolRaleo;
import Utilidades.Inventario.Inventario;
import Utilidades.Persistencia.DAOManager.DAOException;
import Utilidades.Persistencia.DAOManager.DAOManagerBancoDatos;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Führer
 */
public class BancoDatosDAO {

    private static final String OBTENER_TOD0S_LOS_INVENTARIOS = "SELECT ordentrabajo, rute, fecha, rutjcuadrilla, estado, parcela, rodal, fundo, tipoinventario FROM t_bddi_inventario";
    private static final String OBTENER_TOD0S_LOS_INVENTARIOS_PROCESABLES = "SELECT ordentrabajo, rute, fecha, rutjcuadrilla, estado, parcela, rodal, fundo, tipoinventario FROM t_bddi_inventario";// WHERE tipoinventario = 2 OR tipoinventario = 3";
    private static final String OBTENER_EMPRESA_PROPIETARIA = "FORESTAL MASISA S.A.";
    private static final String OBTENER_ESPECIE = "SELECT codigo, descripcion FROM t_bddi_especie WHERE codigo = ?";
    private static final String OBTENER_TIPO_INVENTARIO = "SELECT id, descripcion FROM t_bddi_tipo_inventario WHERE id = ?";
    private static final String OBTENER_NUM_PARCELAS = "SELECT COUNT(numparcela) as parcelas FROM t_bddi_parcela WHERE ordentrabajo = ?";
    //private static final String OBTENER_PARCELAS = "SELECT numparcela, pendiente, manejo, ordentrabajo, latitud, logitud, m2orden, forma FROM t_bddi_parcela WHERE ordentrabajo = ?";
    private static final String OBTENER_SUPERFICIE_PARCELAS = "SELECT SUM(m2) as superficie FROM t_bddi_parcela WHERE ordentrabajo = ?";
    private static final String OBTENER_SUPERFICIE_POR_PARCELA = "SELECT m2 as superficie FROM t_bddi_parcela WHERE numparcela = ?";
    private static final String OBTENER_EMPRESA_SERVICIO = "SELECT rute, nombre FROM t_bddi_empresa_servicio WHERE rute = ?";
    private static final String OBTENER_TODOS_LOS_ARBOLES_RALEO_POR_ID = "SELECT orden_trabajo, numparcela, numero, especie, conpoda, dap, hpoda, htotal FROM t_bddi_arbol_raleo WHERE orden_trabajo = ?";
    private static final String OBTENER_PROMEDIO_ANO_PLANTACION_POR_ID = "select round(AVG(extract(day from anoplantacion)))as dia,round(AVG(extract(month from anoplantacion)))as mes, round(AVG(extract(year from anoplantacion))) as ano from t_bddi_arbol_raleo where orden_trabajo = ?";
    public static String obtenerEmpresaPropietaria(Inventario inv) {
        return OBTENER_EMPRESA_PROPIETARIA;
    }

    public static String obtenerPromedioAnoPlantacion(int ordenT) throws DAOException {
        Connection conn = DAOManagerBancoDatos.getConnection();
        String fecha = "Sin Fecha";
        try (PreparedStatement ps = conn.prepareStatement(OBTENER_PROMEDIO_ANO_PLANTACION_POR_ID)) {
            ps.setInt(1, ordenT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                fecha = rs.getString("ano")+"-"+rs.getString("mes")+"-"+rs.getString("dia") ;
            }
            rs.close();
            ps.close();
            return fecha;
        } catch (SQLException e) {
            throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
            }
        }
    }

    
    public static ArbolRaleo obtenerArbolRaleo(int ordenT) throws DAOException {
        Connection conn = DAOManagerBancoDatos.getConnection();
        ArbolRaleo arbol = null;
        try (PreparedStatement ps = conn.prepareStatement(OBTENER_TODOS_LOS_ARBOLES_RALEO_POR_ID)) {
            ps.setInt(1, ordenT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                arbol = new ArbolRaleo(rs.getInt("orden_trabajo"), rs.getInt("numparcela"), rs.getInt("numero"), rs.getInt("especie"),rs.getInt("condpoda"), rs.getFloat("dap"), rs.getFloat("hpoda"), rs.getFloat("htotal"));
            }
            rs.close();
            ps.close();
            return arbol;
        } catch (SQLException e) {
            throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
            }
        }
    }

    public static LinkedList<ArbolRaleo> obtenerTodosLosArbolRaleoSeleccionados(Inventario inv) throws DAOException {
        Connection conn = DAOManagerBancoDatos.getConnection();
        LinkedList<ArbolRaleo> arboles = new LinkedList();
        try {
            PreparedStatement ps = conn.prepareStatement(OBTENER_TODOS_LOS_ARBOLES_RALEO_POR_ID);
            ps.setInt(1, inv.getOrdenTrabajo());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("asdasdasdaskjdhask");
                System.out.println(rs.toString());
                //orden_trabajo, numparcela, numero, especie, conpoda, dap, hpoda, htotal
                arboles.add(new ArbolRaleo(rs.getInt("orden_trabajo"), rs.getInt("numparcela"), rs.getInt("numero"), rs.getInt("especie"), rs.getInt("conpoda"), rs.getFloat("dap"), rs.getFloat("hpoda"), rs.getFloat("htotal")));
            }
            rs.close();
            ps.close();
            return arboles;
        } catch (SQLException e) {
            System.out.println(e.toString() + "\nERROR");
            throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
            }
        }
    }

    public static String obtenerEspecie(int cod) throws DAOException {
        Connection conn = DAOManagerBancoDatos.getConnection();
        String especie = "";
        try (PreparedStatement ps = conn.prepareStatement(OBTENER_ESPECIE)) {
            ps.setInt(1, cod);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                especie = rs.getString("descripcion");
                //especie = rs.getString("descripcion");
            }
            rs.close();
            ps.close();
            return especie;
        } catch (Exception e) {
            throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
            }
        }
    }

    public static String obtenerTipoInventario(int id) throws DAOException {
        Connection conn = DAOManagerBancoDatos.getConnection();
        String especie = "";
        try (PreparedStatement ps = conn.prepareStatement(OBTENER_TIPO_INVENTARIO)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                especie = rs.getString("descripcion");
                //especie = rs.getString("descripcion");
            }
            rs.close();
            ps.close();
            return especie;
        } catch (Exception e) {
            throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
            }
        }
    }

    public static int obtenerNumParcelas(Inventario inv) throws DAOException {
        Connection conn = DAOManagerBancoDatos.getConnection();
        int numero = 0;
        try (PreparedStatement ps = conn.prepareStatement(OBTENER_NUM_PARCELAS)) {
            ps.setInt(1, inv.getOrdenTrabajo());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                numero = rs.getInt("parcelas");
            }
            rs.close();
            ps.close();
            return numero;
        } catch (Exception e) {
            throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
            }
        }
    }

    public static float obtenerSuperficieParcelas(Inventario inv) throws DAOException {
        Connection conn = DAOManagerBancoDatos.getConnection();
        float sup = 0;
        try (PreparedStatement ps = conn.prepareStatement(OBTENER_SUPERFICIE_PARCELAS)) {
            ps.setInt(1, inv.getOrdenTrabajo());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sup = rs.getFloat("superficie");
            }
            rs.close();
            ps.close();
            return sup;
        } catch (Exception e) {
            throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
            }
        }
    }

    public static float obtenerSuperficiePorParcela(Integer numero) throws DAOException {
        Connection conn = DAOManagerBancoDatos.getConnection();
        float sup = 0;
        try (PreparedStatement ps = conn.prepareStatement(OBTENER_SUPERFICIE_POR_PARCELA)) {
            ps.setInt(1, numero);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                sup = rs.getFloat("superficie");
            }
            rs.close();
            ps.close();
            return sup;
        } catch (SQLException e) {
            throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
            }
        }
    }

    public static String obtenerEmpresaServicio(Inventario inv) throws DAOException {
        Connection conn = DAOManagerBancoDatos.getConnection();
        String emp = "Sin Información";
        try (PreparedStatement ps = conn.prepareStatement(OBTENER_EMPRESA_SERVICIO)) {
            ps.setInt(1, inv.getRutEmpleado());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                emp = rs.getInt("rute") + " - " + rs.getString("nombre");
                //emp = rs.getString("nombre");
            }
            rs.close();
            ps.close();
            return emp;
        } catch (Exception e) {
            throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
            }
        }
    }

    public static LinkedList<Inventario> obtenerTodosLosInventarios() throws DAOException {
        Connection conn = DAOManagerBancoDatos.getConnection();
        LinkedList<Inventario> inventarios = new LinkedList();
        try (PreparedStatement ps = conn.prepareStatement(OBTENER_TOD0S_LOS_INVENTARIOS)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                inventarios.add(new Inventario(rs.getInt("ordentrabajo"), rs.getInt("rute"), rs.getDate("fecha"),
                        rs.getInt("rutjcuadrilla"), rs.getString("estado"), rs.getInt("parcela"), rs.getString("rodal"),
                        rs.getString("fundo"), rs.getInt("tipoinventario")));
            }
            rs.close();
            ps.close();
            return inventarios;
        } catch (SQLException e) {
            throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
            }
        }
    }

    public static LinkedList<Inventario> obtenerTodosLosInventariosProcesables() throws DAOException {
        Connection conn = DAOManagerBancoDatos.getConnection();
        LinkedList<Inventario> inventarios = new LinkedList();
        try (PreparedStatement ps = conn.prepareStatement(OBTENER_TOD0S_LOS_INVENTARIOS_PROCESABLES)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                inventarios.add(new Inventario(rs.getInt("ordentrabajo"), rs.getInt("rute"), rs.getDate("fecha"),
                        rs.getInt("rutjcuadrilla"), rs.getString("estado"), rs.getInt("parcela"), rs.getString("rodal"),
                        rs.getString("fundo"), rs.getInt("tipoinventario")));
            }
            rs.close();
            ps.close();
            return inventarios;
        } catch (SQLException e) {
            throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
            }
        }
    }

}
