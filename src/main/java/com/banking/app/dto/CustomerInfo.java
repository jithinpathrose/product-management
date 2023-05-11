package com.banking.app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CustomerInfo {

    double income = 0.0;

    int age;

    boolean isStudent = false;
}
