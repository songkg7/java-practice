package com.example.springwebfluxparametersample.domain;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

public record Event(
        String name,

        LocalDateTime time,

        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH")
        LocalDateTime anotherTime
) {
}
