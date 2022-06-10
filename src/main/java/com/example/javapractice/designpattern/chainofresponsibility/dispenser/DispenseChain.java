package com.example.javapractice.designpattern.chainofresponsibility.dispenser;

public interface DispenseChain {

    void setNextChain(DispenseChain nextChain);

    void dispense(Currency currency);

}
