package com.example.test.effectivejava.item42;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OperationTest {

    @Test
    void test_1() {
        Operation minus = Operation.MINUS;
        double apply = minus.apply(5, 2);
        System.out.println("apply = " + apply);
        System.out.println(minus);
        System.out.println(minus.toString().equals("-"));
        System.out.println(minus.equals(Operation.MINUS));
        System.out.println(minus.name());
        System.out.println("- equals MINUS : " + "-".equals(Operation.MINUS.toString()));
        System.out.println(minus.compareTo(Operation.PLUS));
        System.out.println(minus.ordinal());

        assertEquals(3, apply);
    }

}