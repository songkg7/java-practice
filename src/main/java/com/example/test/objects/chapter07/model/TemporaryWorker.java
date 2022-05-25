package com.example.test.objects.chapter07.model;

public class TemporaryWorker extends Employee {

    private int workingTime;

    public TemporaryWorker(String name, int pay) {
        super(name, pay);
    }

    public static TemporaryWorker of(String name, int pay) {
        return new TemporaryWorker(name, pay);
    }

    public void working(int time) {
        this.workingTime = time;
    }

    @Override
    public double calculatePay(double taxRate) {
        return (pay * workingTime) - (pay * workingTime) * taxRate;
    }
}
