package time;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import org.junit.jupiter.api.Test;

public class TimeTest {

    /**
     * NOTE: 시간 관련 APIs
     */
    @Test
    void localDateTime() {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime date = LocalDateTime.of(2021, 1, 1, 0, 0, 0);
        LocalDateTime plusYears = date.plusYears(1);
        LocalDateTime plusMonths = date.plusMonths(1);
        LocalDateTime plusWeeks = date.plusWeeks(1);
        LocalDateTime plusDays = date.plusDays(1L);
        LocalDateTime plusHours = date.plusHours(1);
        LocalDateTime plusMinutes = date.plusMinutes(30);
        LocalDateTime plusSeconds = date.plusSeconds(30);
        LocalDateTime plusNanos = date.plusNanos(30);
        LocalDateTime minusDays = date.minusDays(1L);

        boolean before = date.isBefore(minusDays);
        boolean after = date.isAfter(minusDays);

        LocalTime localTime = date.toLocalTime();
        LocalDate localDate = date.toLocalDate();

        int dayOfYear = date.getDayOfYear();
        int dayOfMonth = date.getDayOfMonth();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        Month month = date.getMonth();
        int monthValue = date.getMonthValue();

        ZonedDateTime systemDefaultTime = date.atZone(ZoneId.systemDefault());
        LocalDateTime utc = LocalDateTime.now(ZoneId.of("UTC"));
        String parisZoneId = "Europe/Paris";
        ZonedDateTime parisTime = LocalDateTime.now(ZoneId.of(parisZoneId))
                .atZone(ZoneId.of(parisZoneId));

        System.out.println("=============================");
        System.out.println("현재시간 = " + now);
        System.out.println("date = " + date);
        System.out.println("plusYears = " + plusYears);
        System.out.println("plusMonths = " + plusMonths);
        System.out.println("plusWeeks = " + plusWeeks);
        System.out.println("plusDays = " + plusDays);
        System.out.println("plusHours = " + plusHours);
        System.out.println("plusMinutes = " + plusMinutes);
        System.out.println("plusSeconds = " + plusSeconds);
        System.out.println("plusNanos = " + plusNanos);
        System.out.println("minusDays = " + minusDays);
        System.out.println("=============================");
        System.out.println("date is before minusDays = " + before);
        System.out.println("date is after minusDays = " + after);
        System.out.println("=============================");
        System.out.println("localTime = " + localTime);
        System.out.println("localDate = " + localDate);
        System.out.println("=============================");
        System.out.println("dayOfYear = " + dayOfYear);
        System.out.println("dayOfMonth = " + dayOfMonth);
        System.out.println("dayOfWeek = " + dayOfWeek);
        System.out.println("month = " + month);
        System.out.println("monthValue = " + monthValue);
        System.out.println("=============================");
        System.out.println("defaultTime = " + systemDefaultTime);
        System.out.println("UTC = " + utc);
        System.out.println("parisTime = " + parisTime);
        System.out.println("=============================");
    }

    @Test
    void calendar() {
        Date now = Calendar.getInstance().getTime();

        System.out.println("=============================");
        System.out.println("now = " + now);
    }

    @Test
    void date() {
        Date now = new Date();
        Date date = new Date(121, 0, 1);

        System.out.println("=============================");
        System.out.println("현재시간 = " + now);
        System.out.println("date = " + date);
    }



}
