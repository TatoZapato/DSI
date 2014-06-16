/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades.Persistencia.DAO;

import Utilidades.Inventario.DetalleParcela;
import Utilidades.Inventario.ParametroParcela;
import Utilidades.Persistencia.DAOManager.DAOException;
import Utilidades.Persistencia.DAOManager.DAOManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Führer
 */
public class ParametroParcelaDAO {

    private static final String INSERTAR_PARAMETRO = "INSERT INTO T_INV_PARAMPARCELA (CD_ORDEN_TRABAJO, FC_MEDICION, TP_INVENTARIO, FUNDO, RODAL, ESPECIE_PRINCIPAL, ESPECIE_SECUNDARIA, FC_PROYECCION) values (?,?,?,?,?,?,?,?)";
    private static final String INSERTAR_DETALLE_PARAMETRO = "INSERT INTO T_INV_DETALLE_PARAMETROPARCELA (CD_ORDEN_TRABAJO, CD_NM_PARCELA, SUPERFICIE, DENSIDAD, AREA_BASAL_MEDIA, DAP_MEDIA, ALTURA_DOMINANTE, VOLUMEN) VALUES (?,?,?,?,?,?,?,?)";
    private static final String ELIMINA_PARAMETRO = "DELETE FROM T_INV_PARAMPARCELA WHERE CD_ORDEN_TRABAJO = ?";
    private static final String ELIMINA_DETALLE_PARAMETRO = "DELETE FROM T_INV_DETALLE_PARAMETROPARCELA WHERE CD_ORDEN_TRABAJO = ?";

    public static boolean insertarParametroParcela(ParametroParcela p) throws DAOException, SQLException {
        Connection conn = DAOManager.getConnection();
        try (PreparedStatement ps = conn.prepareCall(INSERTAR_PARAMETRO)) {
            conn.setAutoCommit(false);
            ps.setInt(1, p.getOrdenTrabajo());
            ps.setDate(2, p.getFechaMedicion());
            ps.setString(3, p.getTipoInventario());
            ps.setInt(4, p.getFundo());
            ps.setInt(5, p.getRodal());
            ps.setString(6, p.getEspeciePrincipal());
            ps.setString(7, p.getEspecieSecundaria());
            ps.setDate(8, new Date(new java.util.Date().getTime()));
            ResultSet rs = ps.executeQuery();
            rs.close();

            for (DetalleParcela detalle : p.getDetalles()) {
                insertarDetalleTablaRodal(detalle);
            }
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

    //Detalle Parcela
    public static boolean insertarDetalleTablaRodal(DetalleParcela p) throws DAOException, SQLException {
        Connection conn = DAOManager.getConnection();
        try (PreparedStatement ps = conn.prepareCall(INSERTAR_DETALLE_PARAMETRO)) {
            ps.setInt(1, p.getOrdenTrabajo());
            ps.setInt(2, p.getNumParcela());
            ps.setDouble(3, p.getSuperficie());
            ps.setDouble(4, p.getDensidad());
            ps.setDouble(5, p.getAreaBasalMedia());
            ps.setDouble(6, p.getDapMedio());
            ps.setDouble(7, p.getAlturaDominante());
            ps.setDouble(8, p.getVolumen());
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

}
