package com.example.javapractice.objects.chapter01.movie.domain;

import lombok.ToString;

@ToString
public class Customer {

    private String name;
    private int age;

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
