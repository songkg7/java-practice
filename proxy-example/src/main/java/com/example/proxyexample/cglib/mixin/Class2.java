package com.example.proxyexample.cglib.mixin;

public class Class2 implements Interface2 {

    @Override
    public String second() {
        return "second behavior";
    }

}