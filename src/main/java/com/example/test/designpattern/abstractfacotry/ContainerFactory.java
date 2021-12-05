package com.example.test.designpattern.abstractfacotry;

import com.example.test.designpattern.abstractfacotry.domain.Container;
import com.example.test.designpattern.abstractfacotry.domain.Ship;

public class ContainerFactory implements Factory {

    @Override
    public Ship buildShip() {
        return new Container("Container Sunny");
    }

}
