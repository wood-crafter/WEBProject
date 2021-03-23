/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Admin;
import Entity.Customer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author phanh
 */
public class CustomerModel {
    public ArrayList<Customer> getAll() throws SQLException, Exception {
        ArrayList<Customer> customers = new ArrayList<>();
        Customer customer = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("SELECT * FROM [Customer]");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("customer_id");
                String fullName = rs.getString("full_name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String username = rs.getString("username");
                String password = rs.getString("password");
                boolean status = rs.getBoolean("status");
                
                customer = new Customer(id, fullName, address, phone, username, password, status);
                customers.add(customer);
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

        return customers;
    }
    
    public Customer findByUsername(String name) throws SQLException, Exception {
        Customer customer = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("SELECT * FROM [Customer] WHERE username = ?");
            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("customer_id");
                String fullName = rs.getString("full_name");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String username = rs.getString("username");
                String password = rs.getString("password");
                boolean status = rs.getBoolean("status");
                
                customer = new Customer(id, fullName, address, phone, username, password, status);
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

        return customer;
    }
      
    public void insert(int id, String fullName, String address, String phone, String username, String password, boolean status) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("INSERT INTO [Customer] (customer_id, full_name, address, phone, username, password, status) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setInt(1, id);
            ps.setString(2, fullName);
            ps.setString(3, address);
            ps.setString(4, address);
            ps.setString(5, address);
            ps.setString(6, address);
            ps.setBoolean(7, status);

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
    
    public void update(int id, String fullName, String address, String phone, String username, String password, boolean status) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("UPDATE [Customer] SET customer_id = ?, full_name = ?, address = ?, phone = ?, username = ?, password = ?, status");
            ps.setInt(1, id);
            ps.setString(2, fullName);
            ps.setString(3, address);
            ps.setString(4, address);
            ps.setString(5, address);
            ps.setString(6, address);
            ps.setBoolean(7, status);

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
