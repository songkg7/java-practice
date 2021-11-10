package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

import com.example.test.nullcheck.Human;
import com.example.test.nullcheck.Money;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TestClassTest {

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

}