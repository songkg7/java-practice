package com.example.javapractice.designpattern.strategy.shipbuildstrategy;

public class Port {
    private BuildStrategy<? extends Ship> buildStrategy;

    public Port(BuildStrategy<? extends Ship> buildStrategy) {
        this.buildStrategy = buildStrategy;
    }

    public Ship build() {
        return buildStrategy.build();
    }
}
