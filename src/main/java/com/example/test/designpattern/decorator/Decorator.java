package com.example.test.designpattern.decorator;

public abstract class Decorator implements Coffee {

    private final Coffee coffee;

    public Decorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String recipe() {
        return coffee.recipe();
    }
}
