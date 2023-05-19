package com.banking.app.repo;

import com.banking.app.dto.Product;
import com.banking.app.rule.Rule;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class ProductRepo {

    private Map<String, Product> repo;

    ProductRepo(List<Rule> rules){
        repo = new HashMap<>();
        rules.stream().forEach(rule -> {
            repo.put(rule.getAction(),new Product(rule.getAction(), rule.getFreeText()));
        });
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
