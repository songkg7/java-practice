package strategy.coffee;

import org.junit.jupiter.api.Test;
import strategy.coffee.domain.Americano;
import strategy.coffee.domain.Espresso;

class CoffeeTest {

    @Test
    void test_1() {
        Barista barista = new Barista();

        barista.makeCoffee(new Americano());
        barista.makeCoffee(new Espresso());
    }

}