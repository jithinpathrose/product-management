package com.banking.app.controller;


import com.banking.app.dto.CustomerInfo;
import com.banking.app.dto.Product;
import com.banking.app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductManagementController {

    @Autowired
    private ProductService productService;

    @GetMapping(value = "/myProducts",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Product>> findMyProduct(@RequestParam Double income,
                                                       @RequestParam Integer age,
                                                       @RequestParam boolean isStudent){
        return ResponseEntity.ok(productService.findMyProducts(new CustomerInfo(income, age, isStudent)));
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addNewProduct(@RequestBody Product product){
        productService.addProduct(product);
        return ResponseEntity.ok(product);
    }

    @GetMapping(value = "/allProducts",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<Product>> findAllProduct(){
        return ResponseEntity.ok(productService.findMyProducts());
    }
}
