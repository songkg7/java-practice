package com.example.test.effectivejava.item34;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;

class PlanetTest {

    @Test
    void test_1() {
        double earthWeight = 70.2;
        double mass = earthWeight / Planet.EARTH.surfaceGravity();
        Arrays.stream(Planet.values())
                .forEach(planet -> System.out.printf("%s에서의 무게는 %f이다.%n", planet, planet.surfaceWeight(mass)));
    }

}