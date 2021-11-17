package com.example.test.designpattern.factory.domain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Sedan extends Car {

    public Sedan() {
        log.info("create Sedan.");
    }

    @Override
    public String getName() {
        return "Sedan";
    }

}
