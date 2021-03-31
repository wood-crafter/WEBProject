/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.BillDetail;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author phanh
 */
public class BillDetailModel {
    public ArrayList<BillDetail> getAll() throws SQLException, Exception {
        ArrayList<BillDetail> billDetails = new ArrayList<>();
        BillDetail billDetail =  null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("SELECT * FROM [BillDetail]");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("bill_id");
                String productID = rs.getString("product_id");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                
                billDetail = new BillDetail(id, productID, quantity, price);
                billDetails.add(billDetail);
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

        return billDetails;
    }
    
    public ArrayList<BillDetail> findById(int Id) throws SQLException, Exception {
        BillDetail billDetail = null;
        ArrayList<BillDetail> billDetails = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("SELECT * FROM [BillDetail] WHERE bill_id = ?");
            ps.setInt(1, Id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("bill_id");
                String productID = rs.getString("product_id");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                
                billDetail = new BillDetail(id, productID, quantity, price);
                billDetails.add(billDetail);
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

        return billDetails;
    }
      
    public void insert(int id, String productID, int quantity, double price) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("INSERT INTO [BillDetail] (bill_id, product_id, quantity, price) VALUES (?, ?, ?, ?)");
            ps.setInt(1, id);
            ps.setString(2, productID);
            ps.setInt(3, quantity);
            ps.setDouble(4, price);

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
}
