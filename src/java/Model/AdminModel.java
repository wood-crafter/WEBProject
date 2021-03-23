/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author phanh
 */
public class AdminModel {
    public ArrayList<Admin> getAllAdmin() throws SQLException, Exception {
        ArrayList<Admin> admins = new ArrayList<>();
        Admin admin = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("SELECT * FROM [admin]");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                
                admin = new Admin(username,password);
                admins.add(admin);
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

        return admins;
    }
    
    public Admin findByAdminName(String name) throws SQLException, Exception {
        Admin admin = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("SELECT * FROM [admin] WHERE username = ?");
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                
                admin = new Admin(username, password);
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

        return admin;
    }
      
    public void insertAdmin(String userName, String password) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("INSERT INTO [admin] (username, password) VALUES (?, ?)");
            ps.setString(1, userName);
            ps.setString(2, password);

            ps.execute();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

    }
    
    public void updateAdmin(String username, String password) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("UPDATE [admin] SET username = ?, password = ?");
            ps.setString(1, username);
            ps.setString(2, password);

            ps.execute();
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

    }
}
