package Utilidades.Persistencia.DAO;

import Utilidades.Inventario.Modelo;
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
 * @author Führer
 */
public class ModeloDAO {

    private static final String OBTENER_TOD0S_LOS_MODELOS = "SELECT * FROM T_INV_MODELOALTURA";
    private static final String OBTENER_MODELO = "SELECT * FROM T_INV_MODELOALTURA WHERE CD_MODELO = ?";
    private static final String INSERTAR_MODELO = "INSERT INTO T_INV_MODELOALTURA (modelo,fechaCreacion,fechaModificacion) VALUES (?,?,?)";
    private static final String ACTUALIZAR_MODELO = "UPDATE T_INV_MODELOALTURA SET modelo = ?, fechaModificacion = ? where idModelo = ?";
    private static final String ELIMINAR_MODELO = "DELETE FROM T_INV_MODELOALTURA WHERE idModelo = ?";

    public static boolean eliminarModelo(Modelo modelo) throws DAOException {
        Connection conn = DAOManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(ELIMINAR_MODELO)) {
            ps.setString(1, modelo.getIdModelo());
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

    public static boolean actualizarModelo(Modelo modelo) throws DAOException {
        Connection conn = DAOManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(ACTUALIZAR_MODELO)) {
            ps.setString(1, modelo.getModelo());
            Date fecha = new Date(new java.util.Date().getTime());
            ps.setDate(2, fecha);
            ps.setString(3, modelo.getIdModelo());
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

    public static boolean insertarModelo(String modelo) throws DAOException, SQLException {
        Connection conn = DAOManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(INSERTAR_MODELO)) {
            ps.setString(1, modelo);
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

    public static LinkedList<Modelo> obtenerTodosLosModelos() throws DAOException {
        Connection conn = DAOManager.getConnection();
        LinkedList<Modelo> modelos = new LinkedList();
        try (PreparedStatement ps = conn.prepareStatement(OBTENER_TOD0S_LOS_MODELOS); ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                System.out.println(rs.getString("IdModelo"));
                modelos.add(new Modelo(rs.getString("IdModelo"), rs.getString("Modelo"), rs.getDate("fechaCreacion"), rs.getDate("fechaModificacion")));
            }
            rs.close();
            ps.close();
            return modelos;
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

    public static String[] obtenerTodosLosModelosArray(){
        try {
            LinkedList<Modelo> modelos = obtenerTodosLosModelos();
            String[] datos = new String[modelos.size()];
            int i = 0;
            for (Modelo dato : modelos) {
                datos[i] = dato.getModelo();
                i++;
            }
            return datos;
        } catch (DAOException dao) {
            JOptionPane.showMessageDialog(null, "Error al obtener Modelos...", "Error", 3);
            return null;
        }
    }
}
