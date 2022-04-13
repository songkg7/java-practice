package com.example.test.basic.functional;

import static com.example.test.basic.functional.HighCost.printIfValidIndex;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class HighCostTest {

    @Test
    @Timeout(5)
    void test() {
        // 함수가 호출될 때만 실행된다.
        printIfValidIndex(0, HighCost::highCostValue);
        printIfValidIndex(-1, HighCost::highCostValue);
        printIfValidIndex(-2, HighCost::highCostValue);
    }
}