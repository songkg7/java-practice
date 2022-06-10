package com.example.javapractice.designpattern.builder;

import com.example.javapractice.designpattern.builder.NyPizza.Size;
import com.example.javapractice.designpattern.builder.Pizza.Topping;
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