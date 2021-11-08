package com.example.test;

import static org.junit.jupiter.api.Assertions.*;

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

}