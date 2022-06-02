package com.example.test.effectivejava.item03;

public class ElvisTwo {

    private static final ElvisTwo INSTANCE = new ElvisTwo();

    // reflection 을 통한 예외는 여전히 존재한다.
    private ElvisTwo() {
    }

    // 정적 팩터리 방식으로 인스턴스를 제공한다. 원한다면 API 를 바꾸지 않고도 싱글톤이 아니게 할 수 있다.
    public static ElvisTwo getInstance() {
        return INSTANCE;
    }

    public void something() {

    }
}
