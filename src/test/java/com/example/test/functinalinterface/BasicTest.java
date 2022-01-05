package com.example.test.functinalinterface;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BasicTest {

    @Test
    @DisplayName("함수형 인터페이스")
    void test_1() {
        // 인자를 받지 않고 리턴값도 없는 Runnable
        Runnable runnable = () -> System.out.println("Runnable!");
        runnable.run();

        // 인자를 받지 않고 T 타입의 객체를 리턴하는 Supplier
        Supplier<String> supplier = () -> "Supplier!";
        String string = supplier.get();
        System.out.println("string = " + string);

        // T 타입의 객체를 인자로 받고 리턴값이 없는 Consumer
        Consumer<String> printString = text -> System.out.println("Miss " + text + "?");
        Consumer<String> printString2 = text -> System.out.println("--> Yes!");
        printString.accept("me");

        printNewLine();
        System.out.println("and then 사용시:");
        printString.andThen(printString2).accept("me");

        printNewLine();
        // T 타입을 인자로 받아 R 타입의 객체를 리턴하는 Function
        Function<Integer, Integer> function = value -> value * 2;
        Integer result = function.apply(3);
        System.out.println("result = " + result);

        printNewLine();
        // T 타입을 인자로 받고 결과로 boolean 리턴하는 Predicate
        Predicate<Integer> isBiggerThanFive = num -> num > 5;
        System.out.println("10 is bigger than 5? : " + isBiggerThanFive.test(10));
        Predicate<String> isEqual = Predicate.isEqual("Google");
        System.out.println((isEqual.test("Google")));
    }

    private void printNewLine() {
        System.out.println();
    }

    @Test
    @DisplayName("함수형 인터페이스 활용")
    void test_2() {

    }
}
