package com.example.test.designpattern.strategy;

import static org.junit.jupiter.api.Assertions.*;

import com.example.test.designpattern.strategy.behavior.DownBehavior;
import com.example.test.designpattern.strategy.behavior.LeftBehavior;
import com.example.test.designpattern.strategy.behavior.RightBehavior;
import com.example.test.designpattern.strategy.behavior.UpBehavior;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void test_1() {
        Car car1 = Car.withBehavior(new UpBehavior());
        Car car2 = Car.withBehavior(new DownBehavior());
        Car car3 = Car.withBehavior(new RightBehavior());
        Car car4 = Car.withBehavior(new LeftBehavior());

        car1.move();
        car2.move();
        car3.move();
        car4.move();
    }

}