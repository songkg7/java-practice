package com.example.test.designpattern.strategy.behavior;

import com.example.test.designpattern.strategy.CarMoveBehavior;

public class LeftBehavior implements CarMoveBehavior {

    @Override
    public void action() {
        System.out.println("Left");
    }

}
