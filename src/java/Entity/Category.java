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
public class Category {
    String id;
    String categoryName;
    String image;
    boolean status;

    public Category(String id, String categoryName, String image, boolean status) {
        this.id = id;
        this.categoryName = categoryName;
        this.image = image;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getImage() {
        return image;
    }

    public boolean isStatus() {
        return status;
    }
}
