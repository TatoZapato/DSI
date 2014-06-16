/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilidades.Persistencia.DAO;

import Utilidades.Inventario.ArbolRaleo;
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
public class ArbolRaleoDAO {

    private static final String OBTENER_TOD0S_LOS_ARBOLES_RALEO_SELECCIONADOS = "SELECT orden_trabajo, numparcela, numero, especie, estrato, fito, dominancia, condpoda, dap, hpoda, htotal, rectitud, copa, bifulcacion, sanidad FROM t_bddi_arbol_raleo WHERE ordentrabajo = ?";

    public static ArbolRaleo obtenerArbolRaleo(int ordenT) throws DAOException {
        Connection conn = DAOManagerBancoDatos.getConnection();
        ArbolRaleo arbol = null;
        try (PreparedStatement ps = conn.prepareStatement(OBTENER_TOD0S_LOS_ARBOLES_RALEO_SELECCIONADOS)) {
            ps.setInt(1, ordenT);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                arbol = new ArbolRaleo(rs.getInt("orden_trabajo"), rs.getInt("numparcela"), rs.getInt("numero"), rs.getInt("especie"), rs.getInt("estrato"), rs.getInt("fito"), rs.getInt("dominancia"), rs.getInt("condpoda"), rs.getFloat("dap"), rs.getFloat("hpoda"), rs.getFloat("htotal"), rs.getInt("rectitud"), rs.getInt("copa"), rs.getInt("bifulcacion"), rs.getInt("sanidad"));
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
            PreparedStatement ps = conn.prepareStatement(OBTENER_TOD0S_LOS_ARBOLES_RALEO_SELECCIONADOS);
            ps.setInt(1, inv.getOrdenTrabajo());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                arboles.add(new ArbolRaleo(rs.getInt("orden_trabajo"), rs.getInt("numparcela"), rs.getInt("numero"), rs.getInt("especie"), rs.getInt("estrato"), rs.getInt("fito"), rs.getInt("dominancia"), rs.getInt("condpoda"), rs.getFloat("dap"), rs.getFloat("hpoda"), rs.getFloat("htotal"), rs.getInt("rectitud"), rs.getInt("copa"), rs.getInt("bifulcacion"), rs.getInt("sanidad")));
            }
            rs.close();
            ps.close();
            return arboles;
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
