package com.example.javapractice.effectivejava.item03;

import java.io.Serializable;

public class ElvisTwo implements Serializable {

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

    // readResolve 를 구현하면 역직렬화할 때 같은 인스턴스를 반환하도록 하여 싱글톤을 유지할 수 있다.
//    private Object readResolve() {
//        return INSTANCE;
//    }
}
