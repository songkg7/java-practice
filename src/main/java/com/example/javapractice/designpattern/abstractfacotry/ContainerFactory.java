package com.example.javapractice.designpattern.abstractfacotry;

import com.example.javapractice.designpattern.abstractfacotry.domain.Container;
import com.example.javapractice.designpattern.abstractfacotry.domain.Ship;

public class ContainerFactory implements Factory<Ship> {

    @Override
    public Ship build() {
        return new Container("Container Sunny");
    }

}
