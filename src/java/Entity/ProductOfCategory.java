/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import java.util.ArrayList;

/**
 *
 * @author phanh
 */
public class ProductOfCategory {
    ArrayList<ArrayList<Product>> productsOfCategory;

    public ProductOfCategory(ArrayList<ArrayList<Product>> productsOfCategory) {
        this.productsOfCategory = productsOfCategory;
    }

    public int getNumberOfProduct(Category category){
        for(int i = 0; i < productsOfCategory.size(); i++){
            if(productsOfCategory.get(i).get(0).cateID.equals(category.id)){
                return productsOfCategory.get(i).size();
            }
        }
        return 0;
    }
    
    public ArrayList<Product> getProductList(Category category){
        for(int i = 0; i < productsOfCategory.size(); i++){
            if(productsOfCategory.get(i).get(0).cateID.equals(category.id)){
                return productsOfCategory.get(i);
            }
        }
        return null;
    }
    
}
