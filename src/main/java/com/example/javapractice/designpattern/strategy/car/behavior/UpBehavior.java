package com.example.javapractice.designpattern.strategy.car.behavior;

public class UpBehavior implements CarMoveBehavior {

    @Override
    public void action() {
        System.out.println("Up");
    }

}
