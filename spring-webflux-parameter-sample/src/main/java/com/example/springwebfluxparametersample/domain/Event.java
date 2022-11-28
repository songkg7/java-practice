package com.example.springwebfluxparametersample.domain;

import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

public record Event(
        String name,

        @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'")
        LocalDateTime time
) {
}
