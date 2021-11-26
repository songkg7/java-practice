package com.example.test.designpattern.chainofresponsibility.dispenser;

public class Won1Dispenser implements DispenseChain {

    private DispenseChain nextChain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.nextChain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        int num = currency.getAmount();
        System.out.println("Dispensing " + num + " 1₩ note");
    }

}
