package com.example.test.designpattern.factory;

import com.example.test.designpattern.factory.domain.Car;
import com.example.test.designpattern.factory.domain.Hybrid;
import com.example.test.designpattern.factory.domain.Sedan;
import com.example.test.designpattern.factory.domain.Truck;
import org.hibernate.TypeMismatchException;

public class Factory {

    public static Car create(Class<? extends Car> clazz) {
        if (clazz.isAssignableFrom(Hybrid.class)) {
            return new Hybrid();
        }
        if (clazz.isAssignableFrom(Sedan.class)) {
            return new Sedan();
        }
        if (clazz.isAssignableFrom(Truck.class)) {
            return new Truck();
        }
        throw new TypeMismatchException(clazz.getName() + "은 자동차가 아닙니다.");
    }

}
