package com.example.test.stream;

import com.example.test.basic.stream.Student;
import java.util.Collection;
import java.util.Comparator;
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

    @Test
    @DisplayName("limit")
    void test_7() {
        // limit 는 가져오는 데이터의 개수를 제한한다.
        Stream.generate(Math::random).limit(5).forEach(System.out::println);
    }

    @Test
    @DisplayName("skip")
    void test_8() {
        // skip 은 데이터를 건너뛰는 처리를 한다.
        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        integers.stream().skip(5).forEach(System.out::println);
    }

    @Test
    @DisplayName("distinct - equals and hashCode 를 사용한 중복의 제거")
    void test_9() {
        // distinct 는 equals and hashCode 를 사용하기 때문에 재정의되지 않은 객체는 의도한대로 동작하지 않을 수 있다.
        List<String> list = List.of("google", "apple", "google", "apple", "samsung");
        list.stream().distinct().forEach(System.out::println);
    }

    @Test
    @DisplayName("equalsAndHashCode 가 재정의되야 distinct 가 동작한다.")
    void test_9_1() {
        Student student1 = Student.of("song", true, 1, 1, 90);
        Student student2 = Student.of("song", true, 1, 1, 90);

        List<Student> students = List.of(student1, student2);
        students.stream().distinct().forEach(System.out::println);
    }

    @Test
    @DisplayName("concat - 사슬같이 이어진")
    void test_10() {
        List<String> list1 = List.of("1", "2", "3", "4", "5");
        List<String> list2 = List.of("due", "caution", "rid", "suggest", "inside");

        Stream.concat(list1.stream(), list2.stream()).forEach(System.out::println);
    }

    @Test
    @DisplayName("sorted - Comparable 이 구현되어 있어야 사용가능!")
    void test_11() {
        List<String> list = List.of("upright", "south", "some", "date", "inward");
        System.out.println("sorted:");
        list.stream().sorted().forEach(System.out::println);

        printNewLine();
        System.out.println("reversed:");
        list.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    private void printNewLine() {
        System.out.println();
    }

    @Test
    @DisplayName("sorted - Comparable 을 구현하지 않았을 경우")
    void test_11_1() {
        List<String> list = List.of("behind", "officer", "stick", "dull", "correct");
        list.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);

        printNewLine();
        System.out.println("reversed:");
        list.stream().sorted(Comparator.comparing(String::length).reversed()).forEach(System.out::println);
    }

    @Test
    @DisplayName("sorted - 직접 Comparator 를 구현하는 경우")
    void test_11_2() {
        List<String> list = List.of("rule", "offer", "ever", "bite", "except");
        //noinspection ComparatorCombinators
        Comparator<String> comparator = (s1, s2) -> Integer.compare(s1.length(), s2.length());
        list.stream().sorted(comparator).forEach(System.out::println);

        printNewLine();
        System.out.println("reversed:");
        list.stream().sorted(comparator.reversed()).forEach(System.out::println);
    }

    @Test
    @DisplayName("max and min")
    void test_12() {
        List<String> list = List.of("gate", "radio", "attempt", "question", "ease");
        System.out.println("max:");
        list.stream().max(String::compareToIgnoreCase).ifPresent(System.out::println);

        printNewLine();
        System.out.println("min:");
        list.stream().min(String::compareToIgnoreCase).ifPresent(System.out::println);
    }
}
