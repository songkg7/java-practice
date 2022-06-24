package factory;

import factory.domain.Car;
import factory.domain.Hybrid;
import org.junit.jupiter.api.Test;

class FactoryTest {

    @Test
    void car() {
        Car car = Factory.create(Hybrid.class);

        System.out.println(car.getClass().getSimpleName());
        System.out.println("car.getName() = " + car.getName());
    }

}