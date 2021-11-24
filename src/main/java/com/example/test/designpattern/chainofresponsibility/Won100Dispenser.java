package com.example.test.designpattern.chainofresponsibility;

public class Won100Dispenser implements DispenseChain {

    private DispenseChain dispenseChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.dispenseChain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= 100) {
            int num = currency.getAmount() / 100;
            int remainder = currency.getAmount() % 100;

            System.out.println("Dispensing " + num + " 100₩ note");

            if (remainder != 0) {
                this.dispenseChain.dispense(new Currency(remainder));
            }
        }
        this.dispenseChain.dispense(currency);
    }

}
