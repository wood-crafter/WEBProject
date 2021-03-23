/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author phanh
 */
public class DBContext {
    public Connection getConnection() throws SQLException{
        try {
            final String SERVER_NAME = "DESKTOP-4ARF9HT\\SQLEXPRESS";
            final String DB_NAME = "SE1428";
            final String PORT = "1433";
            final String USERNAME = "sa";
            final String PASSWORD = "123456";
            
            final String URL = "jdbc:sqlserver://" + SERVER_NAME + ":" + PORT + ";databaseName=" + DB_NAME;
                    
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // connection
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException ex) {
            return null;
        }
    }
}
