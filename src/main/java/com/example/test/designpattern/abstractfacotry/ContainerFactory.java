package com.example.test.designpattern.abstractfacotry;

import com.example.test.designpattern.abstractfacotry.domain.Container;
import com.example.test.designpattern.abstractfacotry.domain.Ship;

public class ContainerFactory implements Factory<Ship> {

    @Override
    public Ship build() {
        return new Container("Container Sunny");
    }

}
