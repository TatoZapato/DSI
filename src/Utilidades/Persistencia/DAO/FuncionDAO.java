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
 * @author Desarrollo
 */
public class FuncionDAO {

    public static final String INSERTAR_FUNCION = "INSERT INTO T_INV_FUNCIONVOLUMEN (codigo,fechaCreacion,fechaUltimaModificacion) VALUES (?,?,?)";
    public static final String OBTENER_TOD0S_LAS_FUNCIONES = "";

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

    public static LinkedList<Funcion> obtenerTodosLasFunciones() throws DAOException {
        Connection conn = DAOManager.getConnection();
        LinkedList<Funcion> funciones = new LinkedList();

        try {
            PreparedStatement ps = conn.prepareStatement(OBTENER_TOD0S_LAS_FUNCIONES);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                funciones.add(new Funcion(rs.getInt("IDFUNCION"), rs.getString("FUNCION"), rs.getString("FECHACREACION"), rs.getString("FECHAULTIMAMODIFICACION")));
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
