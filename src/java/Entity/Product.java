/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

/**
 *
 * @author phanh
 */
public class Product {
    String id;
    String productName;
    int quantity;
    double price;
    String image;
    String description;
    boolean status;
    String cateID;

    public Product(String id, String productName, int quantity, double price, String image, String description, boolean status, String cateID) {
        this.id = id;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.image = image;
        this.description = description;
        this.status = status;
        this.cateID = cateID;
    }

    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public boolean isStatus() {
        return status;
    }

    public String getCateID() {
        return cateID;
    }
}
