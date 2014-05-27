/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades.Persistencia.DAO;

import Utilidades.Inventario.Inventario;
import Utilidades.Persistencia.DAOManager.DAOException;
import Utilidades.Persistencia.DAOManager.DAOManagerBancoDatos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

/**
 *
 * @author Führer
 */
public class InventarioDAO {

    private static final String OBTENER_TOD0S_LOS_INVENTARIOS = "SELECT orden_trabajo, rute, fecha, rutj_cuadrilla, estado, parcela, rodal, fundo, tipo_inventario FROM t_bddi_inventario";
    private static final String OBTENER_TOD0S_LOS_INVENTARIOS_PROCESABLES = "SELECT orden_trabajo, rute, fecha, rutj_cuadrilla, estado, parcela, rodal, fundo, tipo_inventario FROM t_bddi_inventario WHERE tipo_inventario = 2 OR tipo_inventario = 3";
    private static final String OBTENER_INVENTARIO = "SELECT id_funcion, funcion, fecha_creacion, fecha_modificacion FROM T_INV_FUNCIONVOLUMEN WHERE id_funcion = ?";

    public static LinkedList<Inventario> obtenerTodosLosInventarios() throws DAOException {
        Connection conn = DAOManagerBancoDatos.getConnection();
        LinkedList<Inventario> inventarios = new LinkedList();
        try (PreparedStatement ps = conn.prepareStatement(OBTENER_TOD0S_LOS_INVENTARIOS); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                inventarios.add(new Inventario(rs.getInt("ordentrabajo"), rs.getInt("rute"),
                        rs.getDate("fecha"), rs.getInt("rutjcuadrilla"), rs.getString("estado"), rs.getInt("parcela"),
                        rs.getString("rodal"), rs.getString("fundo"), rs.getInt("tipoinventario")));
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
        try (PreparedStatement ps = conn.prepareStatement(OBTENER_TOD0S_LOS_INVENTARIOS_PROCESABLES); ResultSet rs = ps.executeQuery();) {
            while (rs.next()) {
                inventarios.add(new Inventario(rs.getInt("orden_trabajo"), rs.getInt("rute"),
                        rs.getDate("fecha"), rs.getInt("rutj_cuadrilla"), rs.getString("estado"), rs.getInt("parcela"),
                        rs.getString("rodal"), rs.getString("fundo"), rs.getInt("tipo_inventario")));
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
