package com.example.test.basic.functional;

import static com.example.test.basic.functional.HighCost.printIfValidIndex;

import org.junit.jupiter.api.Test;

class HighCostTest {

    @Test
    void test() {
        printIfValidIndex(0, HighCost::highCostValue);
        printIfValidIndex(-1, HighCost::highCostValue);
        printIfValidIndex(-2, HighCost::highCostValue);
    }
}