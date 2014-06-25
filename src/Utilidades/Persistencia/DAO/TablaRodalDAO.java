/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades.Persistencia.DAO;

import Utilidades.Inventario.DetalleTablaRodal;
import Utilidades.Inventario.ParametroGeneral;
import Utilidades.Inventario.TablaRodal;
import Utilidades.Persistencia.DAOManager.DAOException;
import Utilidades.Persistencia.DAOManager.DAOManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Führer
 */
public class TablaRodalDAO {

    private static final String INSERTAR_TABLA_RODAL = "INSERT INTO T_INV_TABLARODAL (CD_ORDEN_TRABAJO,TP_INVENTARIO,FUNDO,RODAL,ESPECIE,FC_MEDICION,FC_PROYECCION,MOD_ALTURA,B0,B1,B2,B3,B4,B5,B6,AJUSTE) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String INSERTAR_TABLA_RODAL_V2 = "INSERT INTO T_INV_TABLARODAL (CD_ORDEN_TRABAJO,TP_INVENTARIO,FUNDO,RODAL,ESPECIE,FC_MEDICION,FC_PROYECCION,MOD_ALTURA,B0,B1,B2,B3,B4,B5,B6,AJUSTE) values (";
    private static final String INSERTAR_DETALLE = "INSERT INTO T_INV_DETALLE_TABLARODAL (CD_ORDEN_TRABAJO, CD_CLASE_DAP, DENSIDAD_TOTAL, DENSIDAD_PODADO, AREA_BASAL, ALTURA_MEDIA, ALTURA_PODA, VOLUMEN_PODADO, VOLUMEN_NO_PODADO, VOLUMEN_TOTAL) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String INSERTAR_DETALLE_V2 = "INSERT INTO T_INV_DETALLE_TABLARODAL (CD_ORDEN_TRABAJO, CD_CLASE_DAP, DENSIDAD_TOTAL, DENSIDAD_PODADO, AREA_BASAL, ALTURA_MEDIA, ALTURA_PODA, VOLUMEN_PODADO, VOLUMEN_NO_PODADO, VOLUMEN_TOTAL, DENSIDAD_NO_PODADO) VALUES (";
    private static final String OBTENER_TABLAS_RODALES = "SELECT gen.CD_ORDEN_TRABAJO as cd, rodal.TP_INVENTARIO as inv, rodal.FUNDO as fundo, rodal.RODAL as rodal, rodal.ESPECIE as especie, rodal.FC_MEDICION as fc_medicio,rodal.FC_PROYECCION as fc_proyeccion,gen.em_propietaria as prop, gen.em_de_servicios as serv  FROM T_INV_TABLARODAL rodal, t_inv_parametrogeneral gen where gen.cd_orden_trabajo = rodal.cd_orden_trabajo";
    private static final String ELIMINA_TABLA_RODAL = "DELETE FROM T_INV_TABLARODAL WHERE CD_ORDEN_TRABAJO = ?";
    private static final String ELIMINA_DETALLE = "DELETE FROM T_INV_DETALLE_TABLARODAL WHERE CD_ORDEN_TRABAJO = ?";

    public static boolean insertarTablaRodal(TablaRodal t) throws DAOException, SQLException {
        Connection conn = DAOManager.getConnection();
        try {//(PreparedStatement ps = conn.prepareStatement(INSERTAR_TABLA_RODAL)) {
//            conn.setAutoCommit(false);
//            ps.setInt(1, t.getOrdenTrabajo());
//            ps.setString(2, t.getTipoInventario());
//            ps.setInt(3, t.getFundo());
//            ps.setInt(4, t.getRodal());
//            ps.setString(5, t.getEspecie());
//            ps.setDate(6, t.getFechaMedicion());
//            ps.setDate(7, new Date(new java.util.Date().getTime()));
//            ps.setString(8, t.getModAltura());
//            int i = 9;
//            for (double b : t.getBO()) {
//                ps.setDouble(i, b);
//                i++;
//            }
//            System.out.println("SASDAS - 1");
//            ps.setString(16, t.getAjuste());
//            System.out.println("SASDAS - 2");
//            ResultSet rs = ps.executeQuery();
//            rs.close();
//            ps.close();
            conn.setAutoCommit(false);
            Statement ps = conn.createStatement();

            System.out.println("asdasdasdas");
            String att = INSERTAR_TABLA_RODAL_V2 + "";

            System.out.println("asdasdasdas");
            att += "'" + t.getOrdenTrabajo() + "', ";

            System.out.println("asdasdasdas");
            att += "'" + t.getTipoInventario() + "', ";
            System.out.println("asdasdasdas");
            att += "'" + t.getFundo() + "', ";
            System.out.println("asdasdasdas");
            att += "'" + t.getRodal() + "', ";
            System.out.println("asdasdasdas");
            att += "'" + t.getEspecie() + "', ";
            System.out.println("asdasdasdas");
            att += "'" + t.getFechaMedicion() + "', ";
            System.out.println("asdasdasdas");
            att += "to_date(SYSDATE,'DD/MM/RR'), ";
            System.out.println("asdasdasdas");
            att += "'" + t.getModAltura() + "', ";
            System.out.println("asdasdasdas");

            double[] array = t.getBO();
            for (int i = 0; i < array.length; i++) {
                att += "'" + array[i] + "', ";
            }
            att += "'" + t.getAjuste() + "')";
            System.out.println("TABLA RODAL: " + att);
            ps.execute(att);
            for (DetalleTablaRodal det : t.getDetalles()) {
                insertarDetalleTablaRodal(det);
            }

        } catch (Exception e) {
            conn.rollback();
            System.out.println("Error: " + e.getMessage());
            throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
            }
        }
        return true;
    }

    private static boolean insertarDetalleTablaRodal(DetalleTablaRodal t) throws DAOException, SQLException {
        Connection conn = DAOManager.getConnection();
        try {//(PreparedStatement ps = conn.prepareStatement(INSERTAR_DETALLE)) {
//            ps.setInt(1, t.getOrdenTrabajo());
//            ps.setInt(2, t.getClaseDAP());
//            ps.setString(3, t.getDensidadTotal());
//            ps.setString(4, t.getDensidadPodado());
//            ps.setString(5, t.getAreaBasal());
//            ps.setString(6, t.getAlturaMedia());
//            ps.setString(7, t.getAlturaPoda());
//            ps.setString(8, t.getVolumenPodado());
//            ps.setString(9, t.getVolumeNoPodado());
//            ps.setString(10, t.getVolumenTotal());
//            ResultSet rs = ps.executeQuery();
//            rs.close();
//            ps.close();

            Statement ps = conn.createStatement();
            String att = INSERTAR_DETALLE_V2 + "";
            att += "'" + t.getOrdenTrabajo() + "', ";
            att += "'" + t.getClaseDAP() + "', ";
            att += "'" + t.getDensidadTotal() + "', ";
            att += "'" + t.getDensidadPodado() + "', ";
            att += "'" + t.getAreaBasal() + "', ";
            att += "'" + t.getAlturaMedia() + "', ";
            att += "'" + t.getAlturaPoda() + "', ";
            att += "'" + t.getVolumeNoPodado() + "', ";
            att += "'" + t.getVolumeNoPodado() + "', ";
            att += "'" + t.getVolumenTotal() + "',";
            att += "'" + t.getDensidadNoPodado()+"')";

            System.out.println("DETALLE TABLA RODAL: "+att);
            ps.execute(att);
            ps.close();
        } catch (SQLException e) {
            conn.rollback();
            throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
            }
        }
        return true;
    }

    public static boolean eliminaTablaRodal(TablaRodal t) throws DAOException {
        Connection conn = DAOManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(ELIMINA_TABLA_RODAL)) {
            ps.setInt(1, t.getOrdenTrabajo());
            ResultSet rs = ps.executeQuery();
            rs.close();
            ps.close();
            for (DetalleTablaRodal det : t.getDetalles()) {
                eliminaDetalleTablaRodal(det);
            }
        } catch (Exception e) {
            throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
            }
        }
        return true;
    }

    private static boolean eliminaDetalleTablaRodal(DetalleTablaRodal t) throws DAOException {
        Connection conn = DAOManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(ELIMINA_DETALLE)) {
            ps.setInt(1, t.getOrdenTrabajo());
            ResultSet rs = ps.executeQuery();
            rs.close();
            ps.close();
        } catch (Exception e) {
            throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                throw new DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
            }
        }
        return true;
    }
    
    public static LinkedList<TablaRodal> getAllTablasRodales() throws DAOException{
        Connection conn = DAOManager.getConnection();
        LinkedList<TablaRodal> rodales = new LinkedList();

        try (PreparedStatement ps = conn.prepareStatement(OBTENER_TABLAS_RODALES)) {
            ResultSet rs = ps.executeQuery();
            //gen.CD_ORDEN_TRABAJO as cd, rodal.TP_INVENTARIO as inv, rodal.FUNDO as fundo
            //rodal.RODAL as rodal, rodal.ESPECIE as especie, rodal.FC_MEDICION as fc_medicio,
            //rodal.FC_PROYECCION as fc_proyeccion,gen.em_propietaria as prop, gen.em_de_servicios as serv
            while (rs.next()) {
                TablaRodal x = new TablaRodal();
                ParametroGeneral y = new ParametroGeneral();
                y.setEmPropietaria(rs.getString("prop"));
                y.setEmpresaServicios(rs.getString("serv"));
                x.setParametro(y);
                x.setOrdenTrabajo(rs.getInt("cd"));
                x.setTipoInventario(rs.getString("inv"));
                x.setEspecie(rs.getString("especie"));
                x.setFechaMedicion(rs.getString("fc_medicio"));
                x.setFechaProyeccion(rs.getDate("fc_proyeccion"));
                x.setFundo(rs.getString("fundo"));
                x.setRodal(rs.getString("rodal"));
                rodales.add(x);
            }
            rs.close();
            ps.close();
            return rodales;
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
