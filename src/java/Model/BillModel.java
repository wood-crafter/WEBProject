/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Bill;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author phanh
 */
public class BillModel {
    public ArrayList<Bill> getAll() throws SQLException, Exception {
        ArrayList<Bill> bills = new ArrayList<>();
        Bill bill = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("SELECT * FROM [Bill]");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("bill_id");
                Date createDate = rs.getDate("create_date");
                double totalAmount = rs.getDouble("total_amount");
                String recName = rs.getString("rec_name");
                String recAddress = rs.getString("rec_address");
                String recPhone = rs.getString("rec_phone");
                boolean status = rs.getBoolean("status");
                int customerId = rs.getInt("customer_id");
                
                bill = new Bill(id,createDate, totalAmount, recName, recAddress, recPhone,status, customerId);
                bills.add(bill);
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

        return bills;
    }
    
    public Bill findById(int Id) throws SQLException, Exception {
        Bill bill = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("SELECT * FROM [Bill] WHERE bill_id = ?");
            ps.setInt(1, Id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("bill_id");
                Date createDate = rs.getDate("create_date");
                double totalAmount = rs.getDouble("total_amount");
                String recName = rs.getString("rec_name");
                String recAddress = rs.getString("rec_address");
                String recPhone = rs.getString("rec_phone");
                boolean status = rs.getBoolean("status");
                int customerId = rs.getInt("customer_id");
                
                bill = new Bill(id,createDate, totalAmount, recName, recAddress, recPhone,status, customerId);
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

        return bill;
    }
      
    public void insert(Date createDate, double totalAmount, String recName, String recAddress, String recPhone, boolean status, int customerId) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("INSERT INTO [Bill] (create_date, total_amount, rec_name, rec_address, rec_phone, status, customer_id ) VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setDate(1, createDate);
            ps.setDouble(2, totalAmount);
            ps.setString(3, recName);
            ps.setString(4, recAddress);
            ps.setString(5, recPhone);
            ps.setBoolean(6, status);
            ps.setInt(7, customerId);

            ps.execute();
            System.out.println("Inserted!");
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

    }
    
    
    public int getNewestID() throws SQLException, Exception {
        Bill bill = null;
        Connection conn = null;
        PreparedStatement ps = null;
        int id = 0;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("SELECT * FROM [Bill] WHERE bill_id = (SELECT MAX(bill_id) FROM [Bill])");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt("bill_id");
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

        return id;
    }
    
    public void updateStatus(int id, boolean status) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("UPDATE [Bill] SET status = ? WHERE bill_id = ?");
            ps.setInt(2, id);
            ps.setBoolean(1, status);

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
