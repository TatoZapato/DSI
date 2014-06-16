/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilidades.Persistencia.DAO;

import Utilidades.Inventario.FuncionSitio;
import Utilidades.Persistencia.DAOManager.DAOException;
import Utilidades.Persistencia.DAOManager.DAOManager;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import javax.swing.JOptionPane;

/**
 *
 * @author Desarrollo
 */
public class FuncionSitioDAO {
    private static final String INSERTAR_FUNCION = "INSERT INTO T_INV_FUNCIONSITIO (funcion,fechaCreacion,fechaModificacion) VALUES (?,?,?)";
    private static final String OBTENER_TOD0S_LAS_FUNCIONES = "SELECT * FROM T_INV_FUNCIONSITIO";
    private static final String ACTUALIZAR_FUNCION = "UPDATE T_INV_FUNCIONSITIO SET funcion = ?, fechaModificacion = ? where idFuncion = ?";
    private static final String ELIMINAR_FUNCION = "DELETE FROM T_INV_FUNCIONSITIO WHERE idFuncion = ?";
    
    public static boolean eliminaFuncion(FuncionSitio funcion) throws DAOException {
        Connection conn = DAOManager.getConnection();
        try (PreparedStatement ps = conn.prepareCall(ELIMINAR_FUNCION)) {
            ps.setInt(1, funcion.getId());
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

    public static boolean actualizarFuncion(FuncionSitio funcion) throws DAOException {
        Connection conn = DAOManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(ACTUALIZAR_FUNCION)) {
            ps.setString(1, funcion.getFuncion());
            Date fecha = new Date(new java.util.Date().getTime());
            ps.setDate(2, fecha);
            ps.setInt(3, funcion.getId());
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

public static LinkedList<FuncionSitio> obtenerTodosLasFunciones() throws DAOException {
        Connection conn = DAOManager.getConnection();
        LinkedList<FuncionSitio> funciones = new LinkedList();

        try (PreparedStatement ps = conn.prepareStatement(OBTENER_TOD0S_LAS_FUNCIONES)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                funciones.add(new FuncionSitio(rs.getInt("idFuncion"), rs.getString("funcion"), rs.getDate("fechaCreacion"), rs.getDate("fechaModificacion")));
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
    
    public static String[] obtenerTodosLasFuncionesArray() {
        try {
            LinkedList<FuncionSitio> funciones = obtenerTodosLasFunciones();
            String[] datos = new String[funciones.size()];
            int i = 0;
            for (FuncionSitio dato : funciones) {
                datos[i] = dato.getFuncion();
                i++;
            }
            return datos;
        } catch (DAOException e) {
            JOptionPane.showMessageDialog(null, "Error al obtener Modelos...", "Error", 3);
            return null;
        }
    }
}
