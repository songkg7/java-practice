package com.example.test.designpattern.decorator;

public class Milk extends Decorator {

    public Milk(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String recipe() {
        return super.recipe() + " + 우유";
    }
}
