package com.example.test.designpattern.adapter;

public class Nintendo implements JapanElectronicProduct {

    @Override
    public void v110() {
        System.out.println("110v");
    }

    @Override
    public void electricPressure() {
        System.out.println("electricPressure 110v");
    }
}
