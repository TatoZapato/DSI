package Utilidades.Persistencia.DAOManager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Fûhrer
 */
public class DAOManager {
    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String login = "DSI";
    private static final String password = "1234";
    private static final String url = "jdbc:oracle:thin:@localhost:1521:xe";
    
    public static Connection getConnection() throws DAOException{
        Connection conn = null;
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            throw new DAOException(DAOException.IMPOSIBLE_FIND_DRIVER);
        }
        try {
            conn = DriverManager.getConnection(url, login, password);
        } catch (SQLException e) {
            System.out.println(e);
            throw new DAOException(DAOException.IMPOSIBLE_ESTABLISH_CONNECTION);
        }
        return conn;
    }
}
