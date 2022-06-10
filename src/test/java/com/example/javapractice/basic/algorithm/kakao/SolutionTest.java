package com.example.javapractice.basic.algorithm.kakao;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import com.example.javapractice.basic.algorithm.kakao.Main.Solution;
import org.junit.jupiter.api.Test;

class SolutionTest {

    @Test
    void solution() {
        // given
        String[] idList = { "muzi", "frodo", "apeach", "neo" };
        String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
        int k = 2;
        int[] expected = { 2, 1, 1, 0 };

        // when
        int[] answer = new Solution().solution(idList, report, k);

        // then
        assertArrayEquals(expected, answer);
    }

    @Test
    void solution2() {
        // given
        String[] idList = { "con", "ryan" };
        String[] report = { "ryan con", "ryan con", "ryan con", "ryan con" };
        int k = 3;
        int[] expected = { 0, 0 };

        // when
        int[] answer = new Solution().solution(idList, report, k);

        // then
        assertArrayEquals(expected, answer);
    }
}