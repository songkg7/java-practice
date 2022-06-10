package com.example.javapractice.objects.chapter07.model;

public class SalariedEmployee extends Employee {

    public SalariedEmployee(String name, int pay) {
        super(name, pay);
    }

    public static SalariedEmployee of(String name, int pay) {
        return new SalariedEmployee(name, pay);
    }

    @Override
    public double calculatePay(double taxRate) {
        return pay - (pay * taxRate);
    }
}
