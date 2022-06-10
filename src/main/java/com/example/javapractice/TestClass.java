package com.example.javapractice;

import java.time.LocalDateTime;

public class TestClass implements TestInterface {

    @Override
    public void getTime() {
        System.out.println(LocalDateTime.now());
    }

}
