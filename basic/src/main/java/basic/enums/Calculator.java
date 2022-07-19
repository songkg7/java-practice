package basic.enums;

import java.util.Arrays;
import java.util.function.BiFunction;

public enum Calculator {
    PLUS("+", (v1, v2) -> v1 + v2),
    MINUS("-", (v1, v2) -> v1 - v2),
    MULTIPlY("*", (v1, v2) -> v1 * v2),
    DIVIDE("/", (v1, v2) -> v1 / v2);

    private final String operator;
    private final BiFunction<Double, Double, Double> expression;

    Calculator(String operator, BiFunction<Double, Double, Double> expression) {
        this.operator = operator;
        this.expression = expression;
    }

    public static double calculate(String operator, double v1, double v2) {
        return getOperator(operator).expression.apply(v1, v2);
    }

    private static Calculator getOperator(String operator) {
        return Arrays.stream(Calculator.values())
                .filter(o -> o.operator.equals(operator))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("올바른 연산자가 아닙니다."));
    }
}
