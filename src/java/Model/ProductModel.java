/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Customer;
import Entity.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author phanh
 */
public class ProductModel {
    public ArrayList<Product> getAll() throws SQLException, Exception {
        ArrayList<Product> products = new ArrayList<>();
        Product product = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("SELECT * FROM [Product]");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("product_id");
                String productName = rs.getString("product_name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                String description = rs.getString("description");
                boolean status = rs.getBoolean("status");
                String cateID = rs.getString("cate_id");
                
                product = new Product(id, productName, quantity, price, image, description, status, cateID);
                products.add(product);
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

        return products;
    }
    
    public ArrayList<Product> findByCategoryId(String categoryId) throws SQLException, Exception {
        ArrayList<Product> products = new ArrayList<>();
        Product product = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("SELECT * FROM [Product] WHERE cate_id = ?");
            ps.setString(1, categoryId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("product_id");
                String productName = rs.getString("product_name");
                int quantity = rs.getInt("quantity");
                double price = rs.getDouble("price");
                String image = rs.getString("image");
                String description = rs.getString("description");
                boolean status = rs.getBoolean("status");
                String cateID = rs.getString("cate_id");
                
                product = new Product(id, productName, quantity, price, image, description, status, cateID);
                products.add(product);
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

        return products;
    }
}
