package com.example.objects.chapter13;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rectangle {
    private int x, y, width, height;

    public Rectangle(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public int getArea() {
        return width * height;
    }
}
