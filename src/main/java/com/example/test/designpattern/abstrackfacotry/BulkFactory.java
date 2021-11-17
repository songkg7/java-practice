package com.example.test.designpattern.abstrackfacotry;

import com.example.test.designpattern.abstrackfacotry.domain.Bulk;
import com.example.test.designpattern.abstrackfacotry.domain.Ship;

public class BulkFactory implements Factory {

    @Override
    public Ship buildShip() {
        return new Bulk("Bulk AMS RUBY");
    }

}
