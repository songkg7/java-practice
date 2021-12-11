package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import com.example.test.effectivejava.item59.OldRandom;
import com.example.test.nullcheck.Human;
import com.example.test.nullcheck.Money;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}