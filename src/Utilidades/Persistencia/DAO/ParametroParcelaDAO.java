/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades.Persistencia.DAO;

import Utilidades.Inventario.DetalleParcela;
import Utilidades.Inventario.ParametroGeneral;
import Utilidades.Inventario.ParametroParcela;
import Utilidades.Persistencia.DAOManager.DAOException;
import Utilidades.Persistencia.DAOManager.DAOManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

/**
 *
 * @author Führer
 */
public class ParametroParcelaDAO {

    private static final String INSERTAR_PARAMETRO = "INSERT INTO T_INV_PARAMETROPARCELA (CD_ORDEN_TRABAJO, FC_MEDICION, TP_INVENTARIO, FUNDO, RODAL, ESPECIE_PRINCIPAL, ESPECIE_SECUNDARIA, FC_PROYECCION) values (?,?,?,?,?,?,?,?)";
    private static final String INSERTAR_PARAMETRO_V2 = "INSERT INTO T_INV_PARAMETROPARCELA (CD_ORDEN_TRABAJO, FC_MEDICION, TP_INVENTARIO, FUNDO, RODAL, ESPECIE_PRINCIPAL, ESPECIE_SECUNDARIA, FC_PROYECCION) values (";
    private static final String OBTENER_PARAMETROS_PARCELA = "SELECT G.CD_ORDEN_TRABAJO as cd,g.em_propietaria as prop, g.em_de_servicios as serv, G.FUNDO as fundo, G.RODAL as rodal, p.especie_principal as principal,g.es_secundaria as secundaria,g.tp_inventario as inv, g.fc_proyeccion as pro FROM t_inv_parametroparcela P, T_INV_PARAMETROGENERAL G WHERE P.CD_ORDEN_TRABAJO = G.CD_ORDEN_TRABAJO";
    private static final String INSERTAR_DETALLE_PARAMETRO = "INSERT INTO T_INV_DETALLE_PARAMETROPARCELA (CD_ORDEN_TRABAJO, CD_NM_PARCELA, SUPERFICIE, DENSIDAD, AREA_BASAL_MEDIA, DAP_MEDIO, ALTURA_DOMINANTE, VOLUMEN, FACTOR_EXPANSION) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String ELIMINA_PARAMETRO = "DELETE FROM T_INV_PARAMETROPARCELA WHERE CD_ORDEN_TRABAJO = ?";
    private static final String ELIMINA_DETALLE_PARAMETRO = "DELETE FROM T_INV_DETALLE_PARAMETROPARCELA WHERE CD_ORDEN_TRABAJO = ?";

//    public static boolean insertarParametroParcela(ParametroParcela p) throws DAOException, SQLException {
//        Connection conn = DAOManager.getConnection();
//        try (PreparedStatement ps = conn.prepareCall(INSERTAR_PARAMETRO)) {
//            conn.setAutoCommit(false);
//            ps.setInt(1, p.getOrdenTrabajo());
//            ps.setDate(2, p.getFechaMedicion());
//            ps.setString(3, p.getTipoInventario());
//            ps.setInt(4, p.getFundo());
//            ps.setInt(5, p.getRodal());
//            ps.setString(6, p.getEspeciePrincipal());
//            ps.setString(7, p.getEspecieSecundaria());
//            ps.setDate(8, new Date(new java.util.Date().getTime()));
//            ResultSet rs = ps.executeQuery();
//            rs.close();
//            System.out.println("asdasdasd");
//
//            for (DetalleParcela detalle : p.getDetalles()) {
//                insertarDetalleTablaRodal(detalle);
//            }
//            ps.close();
//        } catch (Exception e) {
//            conn.rollback();
//            System.out.println("Error: PArcela - "+e.toString());
//            throw new DAOException(DAOException.IMPOSIBLE_MAKE_QUERY);
//        } finally {
//            try {
//                conn.close();
//            } catch (SQLException e) {
//                throw new DAOException(DAOException.IMPOSIBLE_CLOSE_CONNECTION);
//            }
//        }
//        return true;
//    }

    public static boolean insertarParametroParcela(ParametroParcela p) throws DAOException, SQLException {
        eliminaParametroParcela(p);
        
        Connection conn = DAOManager.getConnection();
        try {
            conn.setAutoCommit(false);
            Statement ps = conn.createStatement();
            String att = INSERTAR_PARAMETRO_V2;
            att += "'"+p.getOrdenTrabajo()+"', ";
            att += "'"+p.getFechaMedicion()+"', ";
            att += "'"+p.getTipoInventario()+"', ";
            att += "'"+p.getFundo()+"', ";
            att += "'"+p.getRodal()+"', ";
            att += "'"+p.getEspeciePrincipal()+"', ";
            att += "'"+p.getEspecieSecundaria()+"', ";
            att += "to_date(SYSDATE,'DD/MM/RR')) ";
            System.out.println("PARCELA INSERT: "+att+"\nSize(): "+p.getDetalles().size());
            ps.execute(att);
            //eliminaDetalleParametro(p);
            for(int i=0 ; i<p.getDetalles().size() ; i++) {
                insertarDetalleTablaRodal(p.getDetalles().get(i));
            }
            
            ps.close();
        } catch (SQLException | DAOException e) {
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
    
    public static boolean insertarDetalleTablaRodal(DetalleParcela p) throws DAOException, SQLException {
        Connection conn = DAOManager.getConnection();
        try (PreparedStatement ps = conn.prepareCall(INSERTAR_DETALLE_PARAMETRO)) {
            ps.setInt(1, p.getOrdenTrabajo());
            ps.setInt(2, p.getNumParcela());
            ps.setString(3, p.getSuperficie());
            ps.setString(4, p.getDensidad());
            ps.setString(5, p.getAreaBasalMedia());
            ps.setString(6, p.getDapMedio());
            ps.setString(7, p.getAlturaDominante());
            ps.setString(8, p.getVolumen());
            ps.setString(9, p.getFactorExpansion());
            ResultSet rs = ps.executeQuery();
            rs.close();
            ps.close();
        } catch (Exception e) {
            conn.rollback();
            System.out.println("Error Detalle Parcela: "+e.toString());
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

    public static boolean eliminaParametroParcela(ParametroParcela p) throws DAOException {
        Connection conn = DAOManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(ELIMINA_PARAMETRO)) {
            ps.setInt(1, p.getOrdenTrabajo());
            ResultSet rs = ps.executeQuery();
            rs.close();
            ps.close();
            for(DetalleParcela detalle : p.getDetalles()){
                eliminaDetalleParametro(detalle);
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

    private static boolean eliminaDetalleParametro(DetalleParcela p) throws DAOException {
        Connection conn = DAOManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(ELIMINA_DETALLE_PARAMETRO)) {
            ps.setInt(1, p.getOrdenTrabajo());
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

    public static LinkedList<ParametroParcela> getAllParametroParcelas() throws DAOException{
        Connection conn = DAOManager.getConnection();
        LinkedList<ParametroParcela> parametro = new LinkedList();

        try (PreparedStatement ps = conn.prepareStatement(OBTENER_PARAMETROS_PARCELA)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ParametroGeneral y =  new ParametroGeneral();
                ParametroParcela x = new ParametroParcela();
                y.setEmPropietaria(rs.getString("prop"));
                y.setEmpresaServicios(rs.getString("serv"));
                x.setOrdenTrabajo(rs.getInt("cd"));
                x.setParametro(y);
                x.setTipoInventario(rs.getString("inv"));
                x.setEspeciePrincipal(rs.getString("principal"));
                x.setEspecieSecundaria(rs.getString("secundaria"));
                x.setFechaProyeccion(rs.getDate("pro"));
                x.setFundo(rs.getString("fundo"));
                x.setRodal(rs.getString("rodal"));
                parametro.add(x);
            }
            rs.close();
            ps.close();
            return parametro;
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
