package com.banking.app.service;

import com.banking.app.dto.CustomerInfo;
import com.banking.app.dto.Product;
import com.banking.app.repo.ProductRepo;
import com.banking.app.rule.ProductTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import static org.h2.util.StringUtils.isNullOrEmpty;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> findMyProducts(CustomerInfo customerInfo) {
        validateCustomer(customerInfo);
        return null;
    }

    @Override
    public void addProduct(Product product) {
        validateProduct(product);
        productRepo.addProduct(product);
    }

    private void validateProduct(Product product) {
        if(null == product || isNullOrEmpty(product.getProductName())) throw new RuntimeException("400. Bad Request. Invalid Product");
    }

    private void validateCustomer(CustomerInfo customerInfo) {
        if(null == customerInfo) throw new RuntimeException("400. Bad Request. Invalid Customer");
    }
}
