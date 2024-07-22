package lk.Ijse.DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static DbConnection dbConnection;

    private Connection connection;

    private DbConnection() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/DNS_Database","root","shalom@12344321");
    }

    public static DbConnection getInstance() throws SQLException {
        if(dbConnection==null){
           return dbConnection=new DbConnection();
        }else {
            return dbConnection;
        }
    }

    public Connection getConection() {
        return connection;
    }
}
