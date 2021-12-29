package com.example.test.basic.flatmap;

import lombok.Value;

@Value(staticConstructor = "from")
public class Student {

    int kor;
    int eng;
    int math;

}
