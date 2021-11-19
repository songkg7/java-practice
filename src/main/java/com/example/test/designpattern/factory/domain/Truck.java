package com.example.test.designpattern.factory.domain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Truck implements Car {

    public Truck() {
        log.info("create Truck.");
    }

    @Override
    public String getName() {
        return "Truck";
    }

}
