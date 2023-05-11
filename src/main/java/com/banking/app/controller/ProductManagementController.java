package com.banking.app.controller;


import com.banking.app.dto.CustomerInfo;
import com.banking.app.dto.Product;
import com.banking.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RestController("/product")
public class ProductManagementController {

    @Autowired
    private ProductService productService;

    @GetMapping("/myProducts")
    public List<Product> findMyProduct(@RequestBody CustomerInfo customerInfo){
        return productService.findMyProducts(customerInfo);
    }

    @PostMapping("/addProduct")
    public HttpStatus addNewProduct(@RequestBody Product product){
        productService.addProduct(product);
        return HttpStatus.CREATED;
    }
}
