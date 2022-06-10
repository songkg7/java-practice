package com.example.javapractice.designpattern.templatemethod;

import org.junit.jupiter.api.Test;

class HouseTemplateTest {

    @Test
    void test() {
        HouseTemplate woodenHouse = new WoodenHouse();
        woodenHouse.buildHouse();

        HouseTemplate glassHouse = new GlassHouse();
        glassHouse.buildHouse();
    }
}