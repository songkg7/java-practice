package com.example.test.functinalinterface;

import java.util.function.BiFunction;
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
    @DisplayName("함수형 인터페이스 활용 - Function")
    void test_2() {
        Function<Integer, Double> add =  n -> n + 2.0;
        Function<Double, Double> multiply = n -> n * 5;
        Function<Integer, Double> addAndMultiply = multiply.compose(add);

        Double result = addAndMultiply.apply(1);
        System.out.println("result = " + result);

        printNewLine();
        System.out.println("BiFunction");
        BiFunction<String, String, String> function1 = (s1, s2) -> s1 + s2;
        System.out.println("String sum = " + function1.apply("Hello", "World!"));
    }

    @Test
    @DisplayName("Function - andThan 메서드")
    void test_2_1() {
        BiFunction<Integer, Integer, Double> func1 = Math::pow;
        Function<Double, String> func2 = a1 -> "Result: " + a1;

        String result = func1.andThen(func2).apply(2, 3);
        System.out.println("result = " + result);
    }

    @Test
    @DisplayName("Function - function 을 인자로 전달하여 다양한 결과를 생성")
    void test2_2() {
        String result1 = powAndReturnString(2, 3, num -> "Result: " + num * 3);
        String result2 = powAndReturnString(4, 3, num -> "Result 2: " + num);
        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }

    public static String powAndReturnString(int num1, int num2, Function<Double, String> funcConvert) {
        BiFunction<Integer, Integer, Double> funcPow = Math::pow;
        return funcPow.andThen(funcConvert).apply(num1, num2);
    }
}
