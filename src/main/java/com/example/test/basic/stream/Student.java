package com.example.test.basic.stream;

import lombok.Value;

@Value(staticConstructor = "of")
public class Student {

    enum Level {
        HIGH, MIDDLE, LOW
    }

    String name;
    boolean isMale;
    int grade;
    int clazz;
    int score;

}
