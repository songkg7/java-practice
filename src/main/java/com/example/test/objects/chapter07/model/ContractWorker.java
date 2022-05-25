package com.example.test.objects.chapter07.model;

public class ContractWorker extends Employee {

    public ContractWorker(String name, int pay) {
        super(name, pay);
    }

    public static ContractWorker of(String name, int pay) {
        return new ContractWorker(name, pay);
    }

    @Override
    public double calculatePay(double taxRate) {
        return pay - (pay * taxRate);
    }
}
