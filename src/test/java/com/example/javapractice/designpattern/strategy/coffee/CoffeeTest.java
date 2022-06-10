package com.example.javapractice.designpattern.strategy.coffee;

import com.example.javapractice.designpattern.strategy.coffee.domain.Americano;
import com.example.javapractice.designpattern.strategy.coffee.domain.Espresso;
import org.junit.jupiter.api.Test;

class CoffeeTest {

    @Test
    void test_1() {
        Barista barista = new Barista();

        barista.makeCoffee(new Americano());
        barista.makeCoffee(new Espresso());
    }

}