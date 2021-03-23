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
public class Customer {
    int id;
    String fullName;
    String address;
    String phone;
    String username;
    String password;
    boolean status;

    public Customer(int id, String fullName, String address, String phone, String username, String password, boolean status) {
        this.id = id;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean isStatus() {
        return status;
    }
}
