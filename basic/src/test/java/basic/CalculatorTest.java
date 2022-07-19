package basic;

import basic.enums.Calculator;
import org.junit.jupiter.api.Test;

class CalculatorTest {

    @Test
    void function() {
        double plus = Calculator.calculate("+", 2, 3);
        double minus = Calculator.calculate("-", 2, 3);
        double multiply = Calculator.calculate("*", 2, 3);
        double divide = Calculator.calculate("/", 2, 3);

        System.out.println("plus = " + plus);
        System.out.println("minus = " + minus);
        System.out.println("multiply = " + multiply);
        System.out.println("divide = " + divide);
    }
}
