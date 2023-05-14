package com.banking.app.repo;

import com.banking.app.dto.Product;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
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

    public Product get(String action) {
        return repo.get(action);
    }

    public List<Product> getAll() {
        return new ArrayList<>(repo.values());
    }
}
