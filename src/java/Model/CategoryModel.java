/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import Entity.Category;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author phanh
 */
public class CategoryModel {
    public ArrayList<Category> getAll() throws SQLException, Exception {
        ArrayList<Category> categories = new ArrayList<>();
        Category category =  null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("SELECT * FROM [Category]");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("category_id");
                String name = rs.getString("category_name");
                String image = rs.getString("image");
                boolean status = rs.getBoolean("status");
                
                category = new Category(id, name, image, status);
                categories.add(category);
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

        return categories;
    }
    
    public Category findById(int Id) throws SQLException, Exception {
        Category category = null;
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("SELECT * FROM [Category] WHERE category_id = ?");
            ps.setInt(1, Id);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String id = rs.getString("category_id");
                String name = rs.getString("category_name");
                String image = rs.getString("image");
                boolean status = rs.getBoolean("status");
                
                category = new Category(id, name, image, status);
            }
        } finally {
            if (conn != null) {
                conn.close();
            }
            if (ps != null) {
                ps.close();
            }
        }

        return category;
    }
      
    public void insert(int id, String name, String image, boolean status) throws SQLException, Exception {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement("INSERT INTO [Category] (category_id, category_name, image, status) VALUES (?, ?, ?, ?)");
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setString(3, image);
            ps.setBoolean(4, status);

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
