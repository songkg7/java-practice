package com.example.test.designpattern.strategy.coffee.domain;

import com.example.test.designpattern.strategy.coffee.Coffee;

public class Americano implements Coffee {

    @Override
    public void brew() {
        System.out.println("Americano");
    }

}
