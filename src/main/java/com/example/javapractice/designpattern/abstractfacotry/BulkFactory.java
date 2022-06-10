package com.example.javapractice.designpattern.abstractfacotry;

import com.example.javapractice.designpattern.abstractfacotry.domain.Bulk;
import com.example.javapractice.designpattern.abstractfacotry.domain.Ship;

public class BulkFactory implements Factory<Ship> {

    @Override
    public Ship build() {
        return new Bulk("Bulk AMS RUBY");
    }

}
