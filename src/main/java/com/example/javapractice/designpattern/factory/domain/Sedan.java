package com.example.javapractice.designpattern.factory.domain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Sedan implements Car {

    public Sedan() {
        log.info("create Sedan.");
    }

    @Override
    public String getName() {
        return "Sedan";
    }

}
