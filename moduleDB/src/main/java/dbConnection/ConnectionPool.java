package dbConnection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.*;

public class ConnectionPool {
    private static ConnectionPool instance = new ConnectionPool();

    private ConnectionPool() {
    }

    public static ConnectionPool getInstance() {
        return instance;
    }

    public Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/training_db", "root", "123456");
//            Context context = new InitialContext();
//            Context root = (Context) context.lookup("java:comp/env");
//            DataSource dataSource = (DataSource) root.lookup("jdbc/FestTeam_DB");
//            conn = dataSource.getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
//        } catch (NamingException e) {
//            e.printStackTrace();
        }
        return conn;
    }

}
