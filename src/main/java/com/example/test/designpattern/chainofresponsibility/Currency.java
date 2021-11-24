package com.example.test.designpattern.chainofresponsibility;

import lombok.Getter;

@Getter
public class Currency {

    private int amount;

    public Currency(int amount) {
        this.amount = amount;
    }

}
