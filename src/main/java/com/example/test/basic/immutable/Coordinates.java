package com.example.test.basic.immutable;

import lombok.Value;

@Value(staticConstructor = "of")
public class Coordinates {
    double longitude;
    double latitude;
}
