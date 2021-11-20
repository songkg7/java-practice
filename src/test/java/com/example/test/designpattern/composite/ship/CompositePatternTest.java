package com.example.test.designpattern.composite.ship;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import com.example.test.designpattern.composite.ship.leaf.Captain;
import com.example.test.designpattern.composite.ship.leaf.Chef;
import com.example.test.designpattern.composite.ship.leaf.Sailor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class CompositePatternTest {

    @Test
    void test_1() {

        Captain captain = new Captain("captain", 28);
        Chef chef = new Chef("chef", 27);
        Sailor sailor = new Sailor("sailor", 26);

        Ship ship = Ship.building().addComponent(captain);

        Ship ship1 = ship.addComponent(chef);

        ship.addComponent(sailor);

        System.out.println(ship.getCrews());
        System.out.println(ship1.getCrews());

        assertThat(ship).isNotEqualTo(ship1);
        assertNotEquals(ship.getCrews().size(), ship1.getCrews().size());

    }

}