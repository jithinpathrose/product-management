package com.banking.app.repo;

import com.banking.app.dto.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductRepo {

    private Map<String, Product> repo;

    ProductRepo(){
        repo = new HashMap<>();
    }

    public void addProduct(Product product){
        boolean status = repo.containsKey(product.getProductName().trim()) ? false : true;
        if(status){
            repo.put(product.getProductName().trim(), product);
        } else{
            throw new RuntimeException("Product Already Present");
        }
    }
}
