package basicsyntax.functional;

import static basicsyntax.functional.HighCost.printIfValidIndex;

import org.junit.jupiter.api.Test;

class HighCostTest {

    @Test
    void test() {
        printIfValidIndex(0, HighCost::highCostValue);
        printIfValidIndex(-1, HighCost::highCostValue);
        printIfValidIndex(-2, HighCost::highCostValue);
    }
}