package com.example.test.objects.chapter07.model;

import lombok.Value;

@Value
public class Employee {

    String name;
    int pay;

    public static Employee of(String name, int pay) {
        return new Employee(name, pay);
    }

    public double calculatePay(double taxRate) {
        return pay - (pay * taxRate);
    }
}
