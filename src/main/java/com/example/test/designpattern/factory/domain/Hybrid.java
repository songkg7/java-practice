package com.example.test.designpattern.factory.domain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Hybrid extends Car {

    public Hybrid() {
        log.info("create Hybrid.");
    }

    @Override
    public String getName() {
        return "Hybrid";
    }

}
