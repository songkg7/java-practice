package com.example.test.basic.functional;

import static com.example.test.basic.functional.HighCost.highCostValue;
import static com.example.test.basic.functional.HighCost.printIfValidIndex;

import org.junit.jupiter.api.Test;

class HighCostTest {

    @Test
    void test() {
        printIfValidIndex(0, highCostValue());
        printIfValidIndex(-1, highCostValue());
        printIfValidIndex(-2, highCostValue());
    }
}