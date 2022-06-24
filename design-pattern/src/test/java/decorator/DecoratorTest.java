package decorator;

import org.junit.jupiter.api.Test;

class DecoratorTest {

    @Test
    void coffee() {
        Coffee espresso = new Espresso();
        Coffee americano = new Water(new Espresso());
        Coffee latte = new Milk(new Espresso());
        Coffee lightWaterLatte = new Water(new Milk(new Espresso()));

        System.out.println("Espresso: " + espresso.recipe());
        System.out.println("Americano: " + americano.recipe());
        System.out.println("Latte: " + latte.recipe());
        System.out.println("LightWaterLatte: " + lightWaterLatte.recipe());
    }
}