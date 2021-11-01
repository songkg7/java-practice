package com.example.test.time;

import java.time.LocalDateTime;
import java.util.UUID;

public class TestDto {

    private UUID id;
    private LocalDateTime time;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

}
