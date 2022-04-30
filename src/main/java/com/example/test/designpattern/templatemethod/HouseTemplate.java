package com.example.test.designpattern.templatemethod;

public abstract class HouseTemplate {

    public final void buildHouse() {
        buildFoundation();
        buildPillars();
        buildWalls();
        buildWindows();
        System.out.println("House is built.");
    }

    protected void buildWindows() {
        System.out.println("Building Glass Windows.");
    }

    protected abstract void buildWalls();

    protected abstract void buildPillars();

    private void buildFoundation() {
        System.out.println("building foundation with cement, iron rods and sand.");
    }

}
