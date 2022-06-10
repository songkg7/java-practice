package com.example.javapractice.basic.enums;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.UnsupportedTemporalTypeException;
import java.util.function.BiFunction;

public enum TimeUtils {

    LOCAL_DATE(DateTimeFormatter.ofPattern("yyyyMMdd"), (temporal, formatter) -> formatter.format(temporal)),
    LOCAL_DATE_TIME(DateTimeFormatter.ofPattern("yyyyMMddHHmm"), (temporal, formatter) -> formatter.format(temporal));

    private final DateTimeFormatter formatter;

    private final BiFunction<Temporal, DateTimeFormatter, String> expression;

    TimeUtils(DateTimeFormatter formatter, BiFunction<Temporal, DateTimeFormatter, String> expression) {
        this.formatter = formatter;
        this.expression = expression;
    }

    public DateTimeFormatter formatter() {
        return formatter;
    }

    public static LocalDateTime parseLocalDateTime(String timeString) {
        return LocalDateTime.parse(timeString, LOCAL_DATE_TIME.formatter);
    }

    public static LocalDate parseLocalDate(String timeString) {
        return LocalDate.parse(timeString, LOCAL_DATE.formatter);
    }

    // NOTE: instanceof 를 하지 않고 타입을 확정할 수 없을까?
    public static <T extends Temporal> String format(T time) {
        if (time instanceof LocalDateTime) {
            return LOCAL_DATE_TIME.formatter.format(time);
        }
        if (time instanceof LocalDate) {
            return LOCAL_DATE.formatter.format(time);
        }
        throw new UnsupportedTemporalTypeException("Unsupported TemporalType.");
    }

    public <T extends Temporal> String formatByLambda(T time) {
        return expression.apply(time, this.formatter);
    }
}
