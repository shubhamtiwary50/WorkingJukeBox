package Utilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jukeboxdatabase";
        String user = "root";
        String pass = "admin@123";
        connection = DriverManager.getConnection(url, user, pass);
        return connection;

    }
}
