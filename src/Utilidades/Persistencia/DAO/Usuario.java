package Utilidades.Persistencia.DAO;

/**
 *
 * @author Führer
 */
import Utilidades.Persistencia.DAOManager.DAOException;
import Utilidades.Persistencia.DAOManager.DAOManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Usuario {

    public static final String OBTENER_USUARIO = "SELECT CLAVE FROM CUENTAS WHERE USUARIO = ?";

    public static String obtenerClave(String codigo) throws DAOException {
        Connection conn = DAOManager.getConnection();
        String clave = null;

        try (PreparedStatement ps = conn.prepareStatement(OBTENER_USUARIO)){
            ps.setString(1, codigo);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                clave = rs.getString("CLAVE");
            }
            rs.close();
            ps.close();

            return clave;
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
    public static boolean existeUsuario(String user) throws DAOException {
        Connection conn = DAOManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement(OBTENER_USUARIO)){
            ps.setString(1, user);
            ResultSet rs = ps.executeQuery();
            boolean retorno = rs.next();
            rs.close();
            ps.close();
            return retorno;
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
