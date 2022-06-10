package com.example.javapractice.designpattern.abstractfacotry;

import com.example.javapractice.designpattern.abstractfacotry.domain.Ship;

public class ShipFactory {

    public static Ship getShip(Factory<Ship> factory) {
        return factory.build();
    }

}
