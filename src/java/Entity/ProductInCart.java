/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import Model.BillDetailModel;
import Model.BillModel;
import Model.ProductModel;
import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author phanh
 */
public class ProductInCart {

    String id;
    String productName;
    int quantity = 0;
    double price;
    String image;
    String description;
    boolean status;
    String cateID;

    ProductModel productModel = new ProductModel();

    public ProductInCart(String id) throws Exception {
        this.id = id;
        Product product = productModel.findById(id);
        this.productName = product.productName;
        this.price = product.price;
        this.image = product.image;
        this.description = product.description;
        this.status = product.status;
        this.cateID = product.cateID;
    }

    public void addOne() {
        this.quantity += 1;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
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

    public ProductModel getProductModel() {
        return productModel;
    }

    public double getTotal() {
        return price * quantity;
    }

    public void createBill(double total,String name, String address, String phone, int id) throws Exception {
        BillModel billModel = new BillModel();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(System.currentTimeMillis());
        
        billModel.insert(date, total, name, address, phone, false, id);

    }
    
    public void createBillDetail() throws Exception {
        BillModel billModel = new BillModel();
        int billID = billModel.getNewestID();
        BillDetailModel billDetailModel = new BillDetailModel();
        billDetailModel.insert(billID, this.id, quantity, price);
    }
}
