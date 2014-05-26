/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades.Persistencia.DAO;

import Utilidades.Inventario.Funcion;
import Utilidades.Persistencia.DAOManager.DAOException;
import Utilidades.Persistencia.DAOManager.DAOManager;
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
public class FuncionDAO {

    private static final String INSERTAR_FUNCION = "INSERT INTO T_INV_FUNCIONVOLUMEN (funcion,fechaCreacion,fechaModificacion) VALUES (?,?,?)";
    private static final String OBTENER_TOD0S_LAS_FUNCIONES = "SELECT * FROM T_INV_FUNCIONVOLUMEN ORDER BY idFuncion ASC";
    private static final String ACTUALIZAR_FUNCION = "UPDATE T_INV_FUNCIONVOLUMEN SET funcion = ?, fechaModificacion = ? where idFuncion = ?";
    private static final String ELIMINAR_FUNCION = "DELETE FROM T_INV_FUNCIONVOLUMEN WHERE idFuncion = ?";

    public static boolean eliminaFuncion(Funcion funcion) throws DAOException {
        Connection conn = DAOManager.getConnection();
        try (PreparedStatement ps = conn.prepareCall(ELIMINAR_FUNCION)) {
            ps.setString(1, funcion.getIdFuncion().toString());
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

    public static boolean insertarFuncion(String expresion) throws DAOException, SQLException {
        Connection conn = DAOManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(INSERTAR_FUNCION)) {
            ps.setString(1, expresion);
            Date fecha = new Date(new java.util.Date().getTime());
            ps.setDate(2, fecha);
            ps.setDate(3, fecha);
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

    public static boolean actualizarFuncion(Funcion funcion) throws DAOException {
        Connection conn = DAOManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(ACTUALIZAR_FUNCION)) {
            ps.setString(1, funcion.getFuncion());
            Date fecha = new Date(new java.util.Date().getTime());
            ps.setDate(2, fecha);
            ps.setString(3, funcion.getIdFuncion().toString());
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

    public static LinkedList<Funcion> obtenerTodosLasFunciones() throws DAOException {
        Connection conn = DAOManager.getConnection();
        LinkedList<Funcion> funciones = new LinkedList();

        try (PreparedStatement ps = conn.prepareStatement(OBTENER_TOD0S_LAS_FUNCIONES)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                funciones.add(new Funcion(rs.getString("idFuncion"), rs.getString("funcion"), rs.getDate("fechaCreacion"), rs.getDate("fechaModificacion")));
            }
            rs.close();
            ps.close();
            return funciones;
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
