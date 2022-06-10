package com.example.javapractice.effectivejava.item03;

public class ElvisOne {

    // public static final field 방식의 singleton
    public static final ElvisOne INSTANCE = new ElvisOne();

    // private 생성자만 존재하므로 객체를 생성할 수가 없기 때문에 인스턴스가 하나뿐임이 보장된다.
    private ElvisOne() {
    }

    public void something() {

    }

}
