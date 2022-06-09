package com.example.test.effectivejava.item04;

public class ForbiddenConstruction {

    // 생성자 안에서 예외를 던지도록 구현해놓으면 reflection 을 통한 외부에서의 생성도 막을 수 있다.
    private ForbiddenConstruction() {
        throw new UnsupportedOperationException("The creation of this class is prohibited.");
    }

    public void printMessage() {
        System.out.println("This is forbiddenConstruction class!");
    }
}
