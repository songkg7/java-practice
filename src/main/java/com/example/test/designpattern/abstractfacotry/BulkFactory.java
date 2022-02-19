package com.example.test.designpattern.abstractfacotry;

import com.example.test.designpattern.abstractfacotry.domain.Bulk;
import com.example.test.designpattern.abstractfacotry.domain.Ship;

public class BulkFactory implements Factory<Ship> {

    @Override
    public Ship build() {
        return new Bulk("Bulk AMS RUBY");
    }

}
