package com.example.springwebfluxparametersample.domain;

import java.time.LocalDateTime;

public record Event(
        String name,
        LocalDateTime time
) {
}
