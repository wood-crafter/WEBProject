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
    
    public Product findById(String Id) throws SQLException, Exception {
        Product product = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("SELECT * FROM [Product] WHERE product_id = ?");
            ps.setString(1, Id);

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
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

        return product;
    }
    
    public void insert(String id, String name, int quantity, double price, String image, String description, String cateID) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("INSERT INTO [Product] (product_id, product_name, quantity, price, image, description, status, cate_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setInt(3, quantity);
            ps.setDouble(4, price);
            ps.setString(5, image);
            ps.setString(6, description);
            ps.setBoolean(7, true);
            ps.setString(8, cateID);

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
    
    public void update(String id, String name, int quantity, double price, String image, String description, String cateID, boolean status) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("UPDATE [Product] SET product_name = ?, quantity = ?,  price = ?, image = ?, description = ?, status = ?, cate_id = ? WHERE product_id = ?");
            ps.setString(8, id);
            ps.setString(1, name);
            ps.setInt(2, quantity);
            ps.setDouble(3, price);
            ps.setString(4, image);
            ps.setString(5, description);
            ps.setBoolean(6, status);
            ps.setString(7, cateID);

            ps.execute();
            System.out.println("Updateed!");
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
