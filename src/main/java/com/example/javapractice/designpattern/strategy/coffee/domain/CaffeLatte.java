package com.example.javapractice.designpattern.strategy.coffee.domain;

import com.example.javapractice.designpattern.strategy.coffee.Coffee;

public class CaffeLatte implements Coffee {

    @Override
    public void brew() {
        System.out.println("CaffeLatte");
    }

}
