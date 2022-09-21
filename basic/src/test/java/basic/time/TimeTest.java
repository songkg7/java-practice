package basic.time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.WeekFields;
import org.junit.jupiter.api.Test;

public class TimeTest {

    @Test
    void zoneDateTime() {
        ZonedDateTime now = ZonedDateTime.now();

        System.out.println("now: " + now);
    }

    @Test
    void weekOfYear() {
        // 38 이 이번 주
        int yearNum = 2022;
        int weekOfYear = 37;

        LocalDate date = LocalDate.of(yearNum, 1, 1)
                .with(WeekFields.ISO.weekOfYear(), weekOfYear);
        System.out.println("date: " + date);

        LocalDate firstDate = date
                .with(DayOfWeek.MONDAY);
        System.out.println("firstDate: " + firstDate);

        LocalDate lastDate = date
                .with(DayOfWeek.SUNDAY);
        System.out.println("lastDate: " + lastDate);
    }

}
