package strategy;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import strategy.car.Car;
import strategy.car.behavior.DownBehavior;
import strategy.car.behavior.LeftBehavior;
import strategy.car.behavior.RightBehavior;
import strategy.car.behavior.UpBehavior;
import strategy.shipbuildstrategy.Container;
import strategy.shipbuildstrategy.ContainerShipStrategy;
import strategy.shipbuildstrategy.Port;
import strategy.shipbuildstrategy.Ship;

class StrategyPatternTest {

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

    @Test
    void shipBuildStrategy() {
        Port port = new Port(new ContainerShipStrategy());
        Ship ship = port.build();

        assertThat(ship).isInstanceOf(Container.class);
    }
}