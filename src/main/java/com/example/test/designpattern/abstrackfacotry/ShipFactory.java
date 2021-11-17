package com.example.test.designpattern.abstrackfacotry;

import com.example.test.designpattern.abstrackfacotry.domain.Ship;

public class ShipFactory {

    public static Ship getShip(Factory factory) {
        return factory.buildShip();
    }

}
