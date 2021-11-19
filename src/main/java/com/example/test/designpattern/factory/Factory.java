package com.example.test.designpattern.factory;

import com.example.test.designpattern.factory.domain.Car;
import com.example.test.designpattern.factory.domain.Hybrid;
import com.example.test.designpattern.factory.domain.Sedan;
import com.example.test.designpattern.factory.domain.Truck;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Factory {

    private static final Map<Class<?>, Supplier<? extends Car>> map = new HashMap<>();

    static {
        map.put(Hybrid.class, Hybrid::new);
        map.put(Sedan.class, Sedan::new);
        map.put(Truck.class, Truck::new);
    }

    public static Car create(Class<? extends Car> clazz) {
        return map.get(clazz).get();
    }

}
