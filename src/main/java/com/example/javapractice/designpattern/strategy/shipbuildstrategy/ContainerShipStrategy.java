package com.example.javapractice.designpattern.strategy.shipbuildstrategy;

public class ContainerShipStrategy implements BuildStrategy<Container> {

    @Override
    public Container build() {
        return new Container();
    }
}
