package com.example.test.stream;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BasicStreamTest {

    @Test
    @DisplayName("generate 1")
    void test_1() {
        // generate 안의 함수는 무한히 호출되기 때문에 limit 로 제약을 준다.
        Stream.generate(() -> "Echo")
                .limit(5)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("generate 2")
    void test_2() {
        // method reference
        Stream.generate(Math::random)
                .limit(5)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("iterate - generate 와는 다르게 args 로 두 개를 받는다.")
    void test_3() {
        // 첫 번째 인자는 초기값, 두 번째 인자로는 함수를 받는다.
        // 초기값을 함수에 대입하면 무한한 스트림이 생성된다.
        Stream.iterate(0, n -> n + 2)
                .limit(5)
                .forEach(System.out::println);
    }

    @Test
    @DisplayName("filter")
    void test_4() {
        // 특정 조건으로 결과를 필터링할 수 있다.
        List<String> list = List.of("battle", "grain", "idea", "history", "day");
        list.stream().filter(s -> s.startsWith("h")).forEach(System.out::println);
    }

    @Test
    @DisplayName("map")
    void test_5() {
        // 특정한 규칙으로 데이터를 변화시킨다.
        List<String> list = List.of("diamond", "heavenly", "pan", "cause", "creature");
        list.stream().map(String::toUpperCase).forEach(System.out::println);
    }

    @Test
    @DisplayName("flatMap")
    void test_6() {
        // flatMap 은 중첩된 데이터들을 펼쳐서 처리한다.
        List<List<String>> nestedList = List.of(
                List.of("leg", "matter", "thing", "put", "neither"),
                List.of("evil", "run", "belief", "outward", "master"));
        nestedList.stream()
                .flatMap(Collection::stream)
                .forEach(System.out::println);

        System.out.println("-------------------");

        nestedList.stream()
                .flatMap(Collection::stream)
                .filter(s -> s.startsWith("m"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

}
