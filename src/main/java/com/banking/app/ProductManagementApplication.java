package com.banking.app;

import com.banking.app.logger.Console;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductManagementApplication {


    public static void main(String[] args){
        Console.logInfo("Starting App . . .");
        SpringApplication.run(ProductManagementApplication.class, args);
    }
}
