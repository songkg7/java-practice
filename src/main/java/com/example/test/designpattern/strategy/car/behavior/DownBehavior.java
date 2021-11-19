package com.example.test.designpattern.strategy.car.behavior;

public class DownBehavior implements CarMoveBehavior {

    @Override
    public void action() {
        System.out.println("Down");
    }

}
