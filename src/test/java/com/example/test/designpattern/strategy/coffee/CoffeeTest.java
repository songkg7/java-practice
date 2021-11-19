package com.example.test.designpattern.strategy.coffee;

import static org.junit.jupiter.api.Assertions.*;

import com.example.test.designpattern.strategy.coffee.domain.Americano;
import com.example.test.designpattern.strategy.coffee.domain.Espresso;
import org.junit.jupiter.api.Test;

class CoffeeTest {

    @Test
    void test_1() {
        Barista barista = new Barista();

        barista.makeCoffee(new Americano());
        barista.makeCoffee(new Espresso());
    }

}