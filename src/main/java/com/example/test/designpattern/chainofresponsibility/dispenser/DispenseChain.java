package com.example.test.designpattern.chainofresponsibility.dispenser;

public interface DispenseChain {

    void setNextChain(DispenseChain nextChain);

    void dispense(Currency currency);

}
