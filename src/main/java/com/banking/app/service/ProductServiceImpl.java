package com.banking.app.service;

import com.banking.app.dto.CustomerInfo;
import com.banking.app.dto.Product;
import com.banking.app.repo.ProductRepo;
import com.banking.app.rule.ProductTranslator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.h2.util.StringUtils.isNullOrEmpty;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepo productRepo;

    @Autowired
    private RuleEngineService ruleEngineService;

    @Override
    public List<Product> findMyProducts(CustomerInfo customerInfo) {
        validateCustomer(customerInfo);
        List<Product> result = ruleEngineService.executeRules(customerInfo).stream().map(action -> productRepo.get(action))
                .filter(product -> null != product).collect(Collectors.toList());

        return result;
    }

    @Override
    public void addProduct(Product product) {
        validateProduct(product);
        System.out.println("Adding product");
        productRepo.addProduct(product);
    }

    public List<Product> findMyProducts(){
        return productRepo.getAll();
    }

    private void validateProduct(Product product) {
        if(null == product || isNullOrEmpty(product.getProductName())) throw new RuntimeException("400. Bad Request. Invalid Product");
    }

    private void validateCustomer(CustomerInfo customerInfo) {
        if(null == customerInfo) throw new RuntimeException("400. Bad Request. Invalid Customer");
    }
}
