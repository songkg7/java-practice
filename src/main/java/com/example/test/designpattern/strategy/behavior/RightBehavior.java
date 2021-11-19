package com.example.test.designpattern.strategy.behavior;

import com.example.test.designpattern.strategy.CarMoveBehavior;

public class RightBehavior implements CarMoveBehavior {

    @Override
    public void action() {
        System.out.println("Right");
    }

}
