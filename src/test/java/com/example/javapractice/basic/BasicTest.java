package com.example.javapractice.basic;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.javapractice.TestClass;
import com.example.javapractice.TestInterface;
import com.example.javapractice.basic.nullcheck.Human;
import com.example.javapractice.basic.nullcheck.Money;
import com.example.javapractice.effectivejava.item59.OldRandom;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StopWatch;

class BasicTest {

    @Test
    void test_1() {
        List<TestInterface> test = new ArrayList<>();
        test.add(new TestClass());

        test.forEach(TestInterface::getTime);

        System.out.println("Signature Test");

    }

    @Test
    @DisplayName("isEmpty() 는 null check 에는 쓸 수 없다.")
    void test_2() {
        List<String> emptyList = new ArrayList<>();
        List<String> nullList = null;

        assertTrue(emptyList.isEmpty());
        assertThrows(NullPointerException.class, () -> nullList.isEmpty());
    }

    @Test
    @DisplayName("5자리 랜덤숫자")
    void test_3() {

        for (int i = 0; i < 1000; i++) {
            int j = (int) (Math.random() * (90_000)) + 10_000;
            System.out.println("num = " + j);
        }

    }

    @Test
    @DisplayName("null check")
    void test_4() {
        Human human = new Human();
        Money money = new Money();

        human.getMoney().getInsect().getName();

        while (true) {
            if (isNull(human.getMoney())) {
                System.out.println("human money is null!!");
                continue;
            }
            if (isNull(human.getMoney().getInsect())) {
                System.out.println("null");
                continue;
            }

            break;
        }

    }

    private boolean isNull(Object object) {
        if (object == null) {
            System.out.println("object is null!!");
            return true;
        }
        return false;
    }

    @Test
    @DisplayName("불변 객체를 사용해야하는 이유 1")
    void test_5() {
        List<Integer> first = new ArrayList<>();

        first.add(0);
        first.add(1);
        first.add(2);

        List<Integer> second = first;

        // second 가 아닌 first 에 값을 할당해준다.
        first.add(3);

        System.out.println("second = " + second);

    }

    @Test
    @DisplayName("불변 객체를 사용해야하는 이유 2")
    void test_5_2() {
        // how to immutable
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);

        Map<String, List<Integer>> mutableList = new HashMap<>();
        mutableList.put("A", integers);

        integers.add(4);

        System.out.println(mutableList);
    }

    @Test
    @DisplayName("Random 값의 잘못된 사용, 값이 한 쪽으로 쏠린다!")
    void test_6_1() {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1_000_000; i++) {
            if (OldRandom.random(n) < n / 2) {
                low++;
            }
        }
        System.out.println("low = " + low);
    }

    @Test
    @DisplayName("개선된 Random.nextInt()")
    void test_6_2() {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1_000_000; i++) {
            if (OldRandom.staticRandom(n) < n / 2) {
                low++;
            }
        }
        System.out.println("low = " + low);
    }


    @Test
    @DisplayName("Random 값의 올바른 생성 - ThreadLocalRandom")
    void test_6_3() {
        int n = 2 * (Integer.MAX_VALUE / 3);
        int low = 0;
        for (int i = 0; i < 1_000_000; i++) {
            int nextInt = ThreadLocalRandom.current().nextInt(1, n);
            if (nextInt < n / 2) {
                low++;
            }
        }
        System.out.println("low = " + low);
    }

    @Test
    @DisplayName("UUID 생성 속도 측정")
    void test_7() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        for (int i = 0; i < 10_000; i++) {
            System.out.println(UUID.randomUUID());
        }
        stopWatch.stop();

        System.out.println(stopWatch.getTotalTimeMillis());
    }

    @Test
    void test_8() {
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> collect = integers.stream()
                .filter(num -> num < 3)
                .map(num -> num * 2)
                .collect(toList());

        System.out.println(collect);
    }

    @Test
    @DisplayName("MultiValueMap add vs set")
    void multiValueMap() {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<>();

        map.set("1", "surprise");
        map.set("1", "list");
        map.add("1", "treat");
        map.set("2", "wave");
        map.set("2", "wave2");
        map.add("3", "wave3");
        System.out.println(map);
    }

    @Test
    @DisplayName("Month enum class 기능 확인")
    void test_10() {
        Month april = Month.APRIL;
        int i = april.ordinal();
        int value = april.getValue();
        int length = april.length(true);

        System.out.println(i);
        System.out.println("value = " + value);
        System.out.println("length = " + length);

    }

    @Test
    @DisplayName("대소문자 변환")
    void toCase() {
        String kor = "ㄱ";
        String eng = "r";

        System.out.println("kor = " + kor.toUpperCase());
        System.out.println("kor = " + kor.toUpperCase(Locale.ROOT));

        System.out.println("eng = " + eng.toUpperCase());
        System.out.println("eng = " + eng.toUpperCase(Locale.ROOT));
    }

    @Test
    void remove_list() {
        List<String> list = List.of("punctual", "grind", "puzzle", "mistake", "pretty");
        List<String> strings = new ArrayList<>(list);
        String element = strings.remove(0);
        System.out.println("strings = " + strings);
    }

    @Test
    void unmodifiableList() {
        List<String> list = new ArrayList<>();
        list.add("hello");
        List<String> unmodifiableList = Collections.unmodifiableList(list);

        // unmodifiableList 에 값을 수정하려고 하면 UnsupportedOperationException 을 던진다.
        assertThrows(UnsupportedOperationException.class, () -> unmodifiableList.add("world!"));
    }

    @Test
    @DisplayName("불변 리스트여도 스트림으로 객체를 수집할 수 있다.")
    void unmodifiableListStream() {
        List<String> list = List.of("spite", "holy", "sorrow", "wild", "student");
        List<String> collect = list.stream()
                .filter(s -> s.startsWith("s"))
                .collect(toList());

        System.out.println("collect = " + collect);
        assertThat(collect).hasSize(3);
    }

    @Test
    void set() {
        Set<String> strings1 = new HashSet<>();
        strings1.add("1");
        strings1.add("2");
        strings1.add("3");
        strings1.add("4");

        Set<String> strings2 = new HashSet<>();
        strings2.add("3");
        strings2.add("4");
        strings2.add("5");
        strings2.add("6");

        Set<String> strings3 = new HashSet<>(strings1);

        System.out.println(strings1.removeAll(strings2));
        System.out.println(strings1);
        System.out.println(strings3);
    }

    @Test
    void set_2() {
        Set<String> prev = new HashSet<>();

        Set<String> cur = new HashSet<>();
        cur.add("3");
        cur.add("4");
        cur.add("5");
        cur.add("6");

        // emptySet 을 지우려고 하면 false 를 return
        assertFalse(prev.removeAll(cur));
        assertThat(prev).isEmpty();
        assertThat(cur).isNotEmpty();
    }

    @Test
    @DisplayName("Stream 을 사용하여 Set 의 기능을 비슷하게 흉내내기")
    void streamSet() {
        Set<String> strings1 = new HashSet<>();
        strings1.add("1");
        strings1.add("2");
        strings1.add("3");
        strings1.add("4");

        Set<String> strings2 = new HashSet<>();
        strings2.add("3");
        strings2.add("4");
        strings2.add("5");
        strings2.add("6");

        Set<String> collect = strings1.stream()
                .filter(s -> strings2.stream().noneMatch(Predicate.isEqual(s)))
                .collect(toSet());

        System.out.println("collect: " + collect);
        strings1.removeAll(strings2);

        assertThat(collect).isEqualTo(strings1);
    }

    @Test
    void removePrefix() {
        String s = "ClassA/test";
        String s1 = s.replaceFirst("ClassA/", "");
        String s2 = s.substring(0, 6);

        System.out.println("s1: " + s1);
        System.out.println("s2: " + s2);
    }

    @Test
    void endWith() {
        String path = "ais-input/202205";

        int targetLength = 6;
        String substring = path.substring(path.length() - targetLength);

        System.out.println("substring: " + substring);
    }
}