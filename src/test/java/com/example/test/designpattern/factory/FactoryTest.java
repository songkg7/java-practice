package com.example.test.designpattern.factory;

import static org.junit.jupiter.api.Assertions.*;

import com.example.test.designpattern.factory.domain.Car;
import com.example.test.designpattern.factory.domain.Hybrid;
import org.junit.jupiter.api.Test;

class FactoryTest {

    @Test
    void car() {
        Car car = Factory.create(Hybrid.class);

        System.out.println(car.getClass().getSimpleName());
    }

}