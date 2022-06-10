package com.example.javapractice.cleancode;

import java.io.Serializable;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public abstract class SerialDate implements Comparable, Serializable, MonthConstants {

    private static final long serialVersionUID = -293716040467423637L;

    public static final DateFormatSymbols DATE_FORMAT_SYMBOLS = new SimpleDateFormat().getDateFormatSymbols();

    public static final int SERIAL_LOWER_BOUND = 2;

    public static final int SERIAL_UPPER_BOUND = 2958465;

    public static final int MINIMUM_YEAR_SUPPORTED = 1900;

    public static final int MAXIMUM_YEAR_SUPPORTED = 9999;

    public static final int MONDAY = Calendar.MONDAY;
    public static final int TUESDAY = Calendar.TUESDAY;
    public static final int WEDNESDAY = Calendar.WEDNESDAY;
    public static final int THURSDAY = Calendar.THURSDAY;
    public static final int FRIDAY = Calendar.FRIDAY;
    public static final int SATURDAY = Calendar.SATURDAY;
    public static final int SUNDAY = Calendar.SUNDAY;

    static final int[] LAST_DAY_OF_MONTH = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
    static final int[] AGGREGATE_DAYS_TO_END_OF_MONTH =
            { 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };

    static final int[] AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH =
            { 0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365 };

    static final int[] LEAP_YEAR_AGGREGATE_DAYS_TO_END_OF_MONTH =
            { 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366 };

    static final int[] LEAP_YEAR_AGGREGATE_DAYS_TO_END_OF_PRECEDING_MONTH =
            { 0, 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366 };

    public static final int FIRST_WEEK_IN_MONTH = 1;
    public static final int SECOND_WEEK_IN_MONTH = 2;
    public static final int THIRD_WEEK_IN_MONTH = 3;
    public static final int FOURTH_WEEK_IN_MONTH = 4;
    public static final int LAST_WEEK_IN_MONTH = 0;

    public static final int INCLUDE_NONE = 0;
    public static final int INCLUDE_FIRST = 1;
    public static final int INCLUDE_SECOND = 2;
    public static final int INCLUDE_BOTH = 3;

    public static final int PRECEDING = -1;
    public static final int NEAREST = 0;
    public static final int FOLLOWING = 1;

    private String description;

    protected SerialDate() {

    }

    public static boolean isValidWeekdayCode(final int code) {
        switch (code) {
            case SUNDAY:
            case MONDAY:
            case TUESDAY:
            case WEDNESDAY:
            case THURSDAY:
            case FRIDAY:
            case SATURDAY:
                return true;
            default:
                return false;
        }
    }

    public static int stringToWeekdayCode(String s) {
        final String[] shortWeekdayNames = DATE_FORMAT_SYMBOLS.getShortWeekdays();
        final String[] weekDayNames = DATE_FORMAT_SYMBOLS.getWeekdays();

        int result = -1;
        s = s.trim();
        for (int i = 0; i < weekDayNames.length; i++) {
            if (s.equals(shortWeekdayNames[i])) {
                result = i;
                break;
            }
            if (s.equals(weekDayNames[i])) {
                result = i;
                break;
            }
        }
        return result;
    }

    public static String weekdayCodeToString(final int weekday) {
        final String[] weekdays = DATE_FORMAT_SYMBOLS.getWeekdays();
        return weekdays[weekday];
    }

    public static String[] getMonths() {
        return getMonths(false);
    }

    public static String[] getMonths(final boolean shortened) {
        if (shortened) {
            return DATE_FORMAT_SYMBOLS.getShortMonths();
        } else {
            return DATE_FORMAT_SYMBOLS.getMonths();
        }
    }
}
