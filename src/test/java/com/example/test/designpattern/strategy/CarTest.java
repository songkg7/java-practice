package com.example.test.designpattern.strategy;

import com.example.test.designpattern.strategy.car.Car;
import com.example.test.designpattern.strategy.car.behavior.DownBehavior;
import com.example.test.designpattern.strategy.car.behavior.LeftBehavior;
import com.example.test.designpattern.strategy.car.behavior.RightBehavior;
import com.example.test.designpattern.strategy.car.behavior.UpBehavior;
import org.junit.jupiter.api.Test;

class CarTest {

    @Test
    void test_1() {
        Car car1 = Car.withBehavior(new UpBehavior());
        Car car2 = Car.withBehavior(new DownBehavior());
        Car car3 = Car.withBehavior(new RightBehavior());
        Car car4 = Car.withBehavior(new LeftBehavior());
        // Car car5 = Car.create(); // NPE

        car1.move();
        car2.move();
        car3.move();
        car4.move();
        // car5.move();
    }

}