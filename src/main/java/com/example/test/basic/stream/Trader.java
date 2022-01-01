package com.example.test.basic.stream;

import lombok.Value;

@Value(staticConstructor = "of")
public class Trader {

    String name;
    City city;

}
