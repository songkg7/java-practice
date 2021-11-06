package com.example.test.generic;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;

public class Generic<T extends TimeClazz> {

    private T type;

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

}
