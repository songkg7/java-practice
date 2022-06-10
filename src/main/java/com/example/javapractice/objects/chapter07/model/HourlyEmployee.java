package com.example.javapractice.objects.chapter07.model;

public class HourlyEmployee extends Employee {

    private final int workingTime;

    public HourlyEmployee(String name, int pay, int workingTime) {
        super(name, pay);
        this.workingTime = workingTime;
    }

    public static HourlyEmployee of(String name, int pay, int workingTime) {
        return new HourlyEmployee(name, pay, workingTime);
    }

    @Override
    public double calculatePay(double taxRate) {
        return (pay * workingTime) - (pay * workingTime) * taxRate;
    }
}
