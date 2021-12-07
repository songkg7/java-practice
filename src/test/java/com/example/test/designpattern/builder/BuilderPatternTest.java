package com.example.test.designpattern.builder;

import static org.junit.jupiter.api.Assertions.*;

import com.example.test.designpattern.builder.NyPizza.Size;
import com.example.test.designpattern.builder.Pizza.Topping;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BuilderPatternTest {

    @Test
    @DisplayName("이펙티브 자바 - 계층적 빌더 패턴 사용")
    void test_1() {
        NyPizza nyPizza = new NyPizza.Builder(Size.SMALL)
                .addTopping(Topping.SAUSAGE)
                .addTopping(Topping.ONION)
                .build();

        Calzone calzone = new Calzone.Builder()
                .addTopping(Topping.HAM)
                .sauceInside()
                .build();
    }

}