package com.example.test.basic.generic;

public class Generic<T extends TimeClazz> {

    private T type;

    public T getType() {
        return type;
    }

    public void setType(T type) {
        this.type = type;
    }

}
