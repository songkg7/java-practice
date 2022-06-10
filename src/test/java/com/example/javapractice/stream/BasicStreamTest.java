package com.example.javapractice.stream;

import static java.util.stream.Collectors.averagingInt;
import static java.util.stream.Collectors.toSet;

import com.example.javapractice.basic.stream.Student;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

    @Test
    @DisplayName("find and match")
    void test_13() {
        List<String> list = List.of("a", "a1", "b", "b1", "c", "c1");
        // stream 은 싱글 스레드에서 동작하므로 첫번째 아이템부터 탐색하여 b 가 출력된다.
        System.out.println("single thread:");
        list.stream().filter(s -> s.startsWith("b")).findFirst().ifPresent(System.out::println);
        list.stream().filter(s -> s.startsWith("b")).findAny().ifPresent(System.out::println);

        printNewLine();
        System.out.println("병렬 처리시:");
        // findFirst 는 병렬로 처리해도 순서에 우선순위를 두어 결과를 리턴해준다.
        list.stream().parallel().filter(s -> s.startsWith("b")).findFirst().ifPresent(System.out::println);
        list.stream().parallel().filter(s -> s.startsWith("b")).findAny().ifPresent(System.out::println);

        printNewLine();
        boolean allMatch = list.stream().allMatch(s -> s.startsWith("b"));
        System.out.println("allMatch: " + allMatch);

        boolean anyMatch = list.stream().anyMatch(s -> s.startsWith("b"));
        System.out.println("anyMatch: " + anyMatch);

        boolean noneMatch = list.stream().noneMatch(s -> s.startsWith("b"));
        System.out.println("noneMatch: " + noneMatch);
    }

    @Test
    @DisplayName("reduction")
    void test_14() {
        Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
                .reduce(Integer::sum)
                .ifPresent(System.out::println);

        // 초기값 있는 reduce
        printNewLine();
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Integer result = list.stream()
                .reduce(10, Integer::sum);
        System.out.println("result = " + result);

        // 병렬처리
        // 병렬처리시 초기값은 각 스트림 연산에 모두 적용된다.
        printNewLine();
        Integer parallelResult = list.stream()
                .parallel()
                .reduce(10, Integer::sum);
        System.out.println("parallelResult = " + parallelResult);

        printNewLine();
        Integer minusResult = list.stream()
                .parallel()
                .reduce(0, (v1, v2) -> v1 - v2);
        System.out.println("minusResult = " + minusResult);

        // 순서있는 병렬 연산
        printNewLine();
        Integer fluentResult = list.stream()
                .parallel()
                .reduce(0, Integer::sum, Integer::sum); // 마지막 파라미터값으로 첫번째 연산과 두번째 연산은 합해야한다는 규칙을 적용한다.
        System.out.println("fluentResult = " + fluentResult);
    }

    @Test
    @DisplayName("collect")
    void test_15() {
        Stream<String> strings = Stream.of("end", "liberty", "parcel", "top", "step");
        HashSet<String> stringSet = strings.collect(HashSet::new, HashSet::add, HashSet::addAll);
        stringSet.forEach(System.out::println);
    }

    @Test
    @DisplayName("collect - Collector 의 사용")
    void test_15_1() {
        Stream<String> strings = Stream.of("uncle", "instant", "dive", "print", "pride");
        Set<String> set = strings.collect(toSet());
        System.out.println("set = " + set);
    }

    @Test
    @DisplayName("collect - 평균값")
    void test_15_2() {
        List<Integer> list = List.of(1, 2, 3, 4);
        Double result = list.stream().collect(averagingInt(value -> value * 2));
        System.out.println("result = " + result);
    }
}
