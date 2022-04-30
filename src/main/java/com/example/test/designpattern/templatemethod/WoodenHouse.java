package com.example.test.designpattern.templatemethod;

public class WoodenHouse extends HouseTemplate {

    @Override
    protected void buildWalls() {
        System.out.println("Building Wooden Walls.");
    }

    @Override
    protected void buildPillars() {
        System.out.println("Building Pillars with wooden coating.");
    }
}
