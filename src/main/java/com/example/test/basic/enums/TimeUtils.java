package com.example.test.basic.enums;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.Temporal;
import java.time.temporal.UnsupportedTemporalTypeException;

public enum TimeUtils {

    LOCAL_DATE(DateTimeFormatter.ofPattern("yyyyMMdd")),
    LOCAL_DATE_TIME(DateTimeFormatter.ofPattern("yyyyMMddHHmm"));

    private final DateTimeFormatter formatter;

    TimeUtils(DateTimeFormatter formatter) {
        this.formatter = formatter;
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

    public static <T extends Temporal> String format(T time) {
        if (time instanceof LocalDateTime) {
            return LOCAL_DATE_TIME.formatter.format(time);
        }
        if (time instanceof LocalDate) {
            return LOCAL_DATE.formatter.format(time);
        }
        throw new UnsupportedTemporalTypeException("Unsupported TemporalType.");
    }
}
