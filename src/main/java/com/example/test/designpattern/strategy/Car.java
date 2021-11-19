package com.example.test.designpattern.strategy;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public final class Car {

    private CarMoveBehavior carMoveBehavior;

    public void move() {
        carMoveBehavior.action();
    }

    public static Car create() {
        return new Car();
    }

    public static Car withBehavior(CarMoveBehavior carMoveBehavior) {
        return new Car(carMoveBehavior);
    }

}
