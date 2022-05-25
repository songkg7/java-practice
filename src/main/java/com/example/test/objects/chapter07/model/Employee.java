package com.example.test.objects.chapter07.model;

import lombok.Getter;

@Getter
public abstract class Employee {

    protected String name;
    protected int pay;

    public Employee(String name, int pay) {
        this.name = name;
        this.pay = pay;
    }

    public abstract double calculatePay(double taxRate);
}
