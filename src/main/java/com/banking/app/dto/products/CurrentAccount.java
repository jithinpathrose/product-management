package com.banking.app.dto.products;

import com.banking.app.dto.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class CurrentAccount extends Product {

    public CurrentAccount(String productName, String productDescription) {
        super(productName, productDescription);
    }
}
