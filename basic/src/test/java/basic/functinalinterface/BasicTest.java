package basic.functinalinterface;

import basic.stream.Student;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.DoubleSupplier;
import java.util.function.Function;
import java.util.function.IntSupplier;
import java.util.function.LongSupplier;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.IntStream;
import java.util.stream.Stream;
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

    @Test
    @DisplayName("Supplier")
    void test_3() {
        Supplier<String> supplier = () -> "Hello, world!";
        String result = supplier.get();
        System.out.println("result = " + result);

        Supplier<String> helloSupplier = this::printHelloWorld;
        String result1 = helloSupplier.get();
        System.out.println("result1 = " + result1);
    }

    private String printHelloWorld() {
        return "Hello, world!";
    }

    @Test
    @DisplayName("Supplier - 어떤 객체도 리턴받을 수 있다.")
    void test_3_1() {
        Supplier<Student> supplier = () -> Student.of("song", true, 1, 2, 100);
        Student student = supplier.get();
        System.out.println("student = " + student);
    }

    @Test
    @DisplayName("Primitive Supplier")
    void test_3_2() {
        String hello = "hello";
        //noinspection ConstantConditions
        BooleanSupplier booleanSupplier = () -> hello.equals("world!");
        IntSupplier intSupplier = hello::length;
        LongSupplier longSupplier = hello::length;
        DoubleSupplier doubleSupplier = () -> 12.34 - hello.length();

        System.out.println("booleanSupplier = " + booleanSupplier.getAsBoolean());
        System.out.println("intSupplier = " + intSupplier.getAsInt());
        System.out.println("longSupplier = " + longSupplier.getAsLong());
        System.out.println("doubleSupplier = " + doubleSupplier.getAsDouble());
    }

    @Test
    @DisplayName("Supplier with Stream.generate()")
    void test3_3() {
        Supplier<Integer> randomSupplier = () -> ThreadLocalRandom.current().nextInt(100);
        Stream.generate(randomSupplier)
                .limit(5)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("Predicate")
    void test_4() {
        Predicate<Integer> predicate = num -> num > 10;
        boolean result = predicate.test(100);
        System.out.println("result = " + result);
    }

    @Test
    @DisplayName("Predicate - and, or")
    void test_4_1() {
        Predicate<Integer> predicate1 = num -> num > 10;
        Predicate<Integer> predicate2 = num -> num < 20;

        boolean result1 = predicate1.and(predicate2).test(25);
        System.out.println("result1 = " + result1);

        boolean result2 = predicate1.and(predicate2).test(15);
        System.out.println("result2 = " + result2);

        boolean result3 = predicate1.or(predicate2).test(25);
        System.out.println("result3 = " + result3);

        boolean result4 = predicate1.or(predicate2).test(15);
        System.out.println("result4 = " + result4);
    }

    @Test
    @DisplayName("Predicate - isEquals, negate")
    void test_4_2() {
        IntStream.range(1, 10)
                .boxed()
                .filter(Predicate.isEqual(5))
                .forEach(System.out::println);

        printSeparateLine();
        Predicate<Integer> predicate = num -> num > 10;
        Predicate<Integer> negate = predicate.negate();

        boolean result = predicate.test(100);
        System.out.println("result = " + result);

        boolean result2 = negate.test(100);
        System.out.println("result2 = " + result2);
        printSeparateLine();
    }

    private void printSeparateLine() {
        System.out.println("---------------------");
    }

    @Test
    @DisplayName("Predicate - in Stream")
    void test_4_3() {
        Stream<Integer> stream = IntStream.range(1, 10).boxed();
        Predicate<Integer> predicate = num -> num < 5;

        stream.filter(predicate).forEach(System.out::println);
    }

    @Test
    @DisplayName("UnaryOperator")
    void test_5() {
        UnaryOperator<Integer> unaryOperator = n -> n * n;
        Integer result = unaryOperator.apply(10);
        System.out.println("result = " + result);

        UnaryOperator<Boolean> unaryOperator1 = b -> !b;
        Boolean result1 = unaryOperator1.apply(false);
        System.out.println("result1 = " + result1);
    }

    @Test
    @DisplayName("binaryOperator")
    void test_6() {
        BinaryOperator<Integer> binaryOperator = (n1, n2) -> n1 * n2;
        Integer result = binaryOperator.apply(2, 5);
        System.out.println("result = " + result);
    }

    @Test
    void test_7() {
        consumerTest(strings -> System.out.println("strings = " + strings));
    }

    void consumerTest(Consumer<List<String>> consumer) {
        List<String> strings = Arrays.asList("snow", "onto", "flatten", "tame", "inch");
        consumer.accept(strings);
    }
}
