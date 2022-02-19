package com.example.test.designpattern.abstractfacotry;

import com.example.test.designpattern.abstractfacotry.domain.Ship;

public class ShipFactory {

    public static Ship getShip(Factory<Ship> factory) {
        return factory.build();
    }

}
