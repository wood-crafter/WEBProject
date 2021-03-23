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
public class BillDetail {
    int billId;
    String productID;
    int quantity;
    double price;

    public BillDetail(int billId, String productID, int quantity, double price) {
        this.billId = billId;
        this.productID = productID;
        this.quantity = quantity;
        this.price = price;
    }

    public int getBillId() {
        return billId;
    }

    public String getProductID() {
        return productID;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}
