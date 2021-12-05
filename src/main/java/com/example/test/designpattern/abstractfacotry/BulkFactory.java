package com.example.test.designpattern.abstractfacotry;

import com.example.test.designpattern.abstractfacotry.domain.Bulk;
import com.example.test.designpattern.abstractfacotry.domain.Ship;

public class BulkFactory implements Factory {

    @Override
    public Ship buildShip() {
        return new Bulk("Bulk AMS RUBY");
    }

}
