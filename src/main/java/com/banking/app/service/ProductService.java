package com.banking.app.service;

import com.banking.app.dto.CustomerInfo;
import com.banking.app.dto.Product;

import java.util.List;

public interface ProductService {

    List<Product> findMyProducts(CustomerInfo customerInfo);

    void addProduct(Product product);
}
