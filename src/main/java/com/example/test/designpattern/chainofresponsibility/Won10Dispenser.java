package com.example.test.designpattern.chainofresponsibility;

public class Won10Dispenser implements DispenseChain {

    private DispenseChain nextChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 10) {
            int num = currency.getAmount() / 10;
            int remainder = currency.getAmount() % 10;

            System.out.println("Dispensing " + num + " 10₩ note");

            if (remainder == 0) {
                return;
            }

            this.nextChain.dispense(new Currency(remainder));
            return;
        }
        this.nextChain.dispense(currency);
    }

}
