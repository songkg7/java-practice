package com.example.test.designpattern.adapter;

public class Samsung implements KoreaElectronicProduct {

    @Override
    public void v220() {
        System.out.println("220v");
    }

    @Override
    public void electricPressure() {
        System.out.println("electricPressure 220v");
    }
}
