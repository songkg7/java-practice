package com.example.test.designpattern.abstrackfacotry;

import static org.junit.jupiter.api.Assertions.*;

import com.example.test.designpattern.abstrackfacotry.domain.Ship;
import org.junit.jupiter.api.Test;

class ShipFactoryTest {

    @Test
    void test_1() {
        Ship bulk = ShipFactory.getShip(new BulkFactory());
        Ship container = ShipFactory.getShip(new ContainerFactory());

        System.out.println("bulk.getName() = " + bulk.getName());
        System.out.println("container.getName() = " + container.getName());
    }

}