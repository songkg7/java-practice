package com.example.test.designpattern.abstrackfacotry;

import com.example.test.designpattern.abstrackfacotry.domain.Container;
import com.example.test.designpattern.abstrackfacotry.domain.Ship;

public class ContainerFactory implements Factory {

    @Override
    public Ship buildShip() {
        return new Container("Container Sunny");
    }

}
