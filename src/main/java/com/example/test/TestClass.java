package com.example.test;

import java.time.LocalDateTime;

public class TestClass implements TestInterface {

    @Override
    public void getTime() {
        System.out.println(LocalDateTime.now());
    }

}
