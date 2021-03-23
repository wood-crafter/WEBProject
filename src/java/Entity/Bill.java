/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.sql.Date;

/**
 *
 * @author phanh
 */
public class Bill {
    int id;
    Date createDate;
    double totalAmount;
    String recName;
    String recAddress;
    String recPhone;
    boolean status;
    int customerID;

    public Bill(int id, Date createDate, double totalAmount, String recName, String recAddress, String recPhone, boolean status, int customerID) {
        this.id = id;
        this.createDate = createDate;
        this.totalAmount = totalAmount;
        this.recName = recName;
        this.recAddress = recAddress;
        this.recPhone = recPhone;
        this.status = status;
        this.customerID = customerID;
    }

    public int getId() {
        return id;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getRecName() {
        return recName;
    }

    public String getRecAddress() {
        return recAddress;
    }

    public String getRecPhone() {
        return recPhone;
    }

    public boolean isStatus() {
        return status;
    }

    public int getCustomerID() {
        return customerID;
    }
}
