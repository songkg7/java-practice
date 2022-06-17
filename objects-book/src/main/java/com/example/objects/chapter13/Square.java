package com.example.objects.chapter13;

public class Square extends Rectangle {

    public Square(int x, int y, int size) {
        super(x, y, size, size);
    }

    // 높이와 너비를 같게 설정해서 정사각형 요구사항을 만족시킨다.
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }

    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
    }
}
