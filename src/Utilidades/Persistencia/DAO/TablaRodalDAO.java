/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades.Persistencia.DAO;

import Utilidades.Inventario.DetalleTablaRodal;
import Utilidades.Inventario.TablaRodal;
import Utilidades.Persistencia.DAOManager.DAOException;
import Utilidades.Persistencia.DAOManager.DAOManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Führer
 */
public class TablaRodalDAO {

    private static final String INSERTAR_TABLA_RODAL = "INSERT INTO T_INV_TABLARODAL (CD_ORDEN_TRABAJO,TP_INVENTARIO,FUNDO,RODAL,ESPECIE,FC_MEDICION,FC_PROYECCION,MOD_ALTURA,B0,B1,B2,B3,B4,B5,B6,AJUSTE) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String INSERTAR_DETALLE = "INSERT INTO T_INV_DETALLE_TABLARODAL (CD_ORDEN_TRABAJO, CD_CLASE_DAP, DENSIDAD_TOTAL, DENSIDAD_RODAL, AREA_BASAL, ALTURA_MEDIA, ALTURA_PODA, VOLUMEN_PODADO, VOLUMEN_NO_PODADO, VOLUMEN_TOTAL) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static final String ELIMINA_TABLA_RODAL = "DELETE FROM T_INV_TABLARODAL WHERE CD_ORDEN_TRABAJO = ?";
    private static final String ELIMINA_DETALLE = "DELETE FROM T_INV_DETALLE_TABLARODAL WHERE CD_ORDEN_TRABAJO = ?";

    public static boolean insertarTablaRodal(TablaRodal t) throws DAOException, SQLException {
        Connection conn = DAOManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(INSERTAR_TABLA_RODAL)) {
            conn.setAutoCommit(false);
            ps.setInt(1, t.getOrdenTrabajo());
            ps.setString(2, t.getTipoInventario());
            ps.setInt(3, t.getFundo());
            ps.setInt(4, t.getRodal());
            ps.setString(5, t.getEspecie());
            ps.setDate(6, t.getFechaMedicion());
            ps.setDate(7, new Date(new java.util.Date().getTime()));
            ps.setString(8, t.getModAltura());
            int i = 9;
            for (double b : t.getBO()) {
                ps.setDouble(i, b);
                i++;
            }
            ps.setString(16, t.getAjuste());
            ResultSet rs = ps.executeQuery();
            rs.close();
            ps.close();
            for (DetalleTablaRodal det : t.getDetalles()) {
                insertarDetalleTablaRodal(det);
            }
        } catch (Exception e) {
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

    private static boolean insertarDetalleTablaRodal(DetalleTablaRodal t) throws DAOException, SQLException {
        Connection conn = DAOManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(INSERTAR_DETALLE)) {
            ps.setInt(1, t.getOrdenTrabajo());
            ps.setInt(2, t.getClaseDAP());
            ps.setFloat(3, t.getDensidadTotal());
            ps.setFloat(4, t.getDensidadPodado());
            ps.setFloat(5, t.getAreaBasal());
            ps.setFloat(6, t.getAlturaMedia());
            ps.setFloat(7, t.getAlturaPoda());
            ps.setFloat(8, t.getVolumenPodado());
            ps.setFloat(9, t.getVolumeNoPodado());
            ps.setFloat(10, t.getVolumenTotal());
            ResultSet rs = ps.executeQuery();
            rs.close();
            ps.close();
        } catch (Exception e) {
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
            for(DetalleTablaRodal det : t.getDetalles()){
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
}
