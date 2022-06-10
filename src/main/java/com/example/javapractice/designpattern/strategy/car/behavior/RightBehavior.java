package com.example.javapractice.designpattern.strategy.car.behavior;

public class RightBehavior implements CarMoveBehavior {

    @Override
    public void action() {
        System.out.println("Right");
    }

}
