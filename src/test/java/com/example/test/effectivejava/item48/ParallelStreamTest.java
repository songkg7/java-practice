package com.example.test.effectivejava.item48;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParallelStreamTest {

    @Test
    @DisplayName("소수 계산 스트림 파이프라인")
    void test_1() {
        long piCount = ParallelStream.pi(100_000_000);
        System.out.println("piCount = " + piCount);
    }

    @Test
    @DisplayName("소수 계산 병렬 스트림 파이프라인")
    void test_2() {
        long piCount = ParallelStream.parallelPi(100_000_000);
        System.out.println("piCount = " + piCount);
    }
}