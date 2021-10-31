package time;

import static java.time.temporal.TemporalAdjusters.lastDayOfMonth;
import static java.time.temporal.TemporalAdjusters.nextOrSame;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.junit.jupiter.api.Test;

/**
 * NOTE: 시간 관련 APIs
 *
 * @see java.time.temporal.TemporalAdjusters
 */
public class TimeTest {

    @Test
    void date() {
        Date now = new Date();
        Date date = new Date(121, 0, 1);

        // 결과가 직관적이지 않으며 toString 으로 반환되는 문자열을 추가로 활용하기도 어렵다.
        // 그렇다고 자체적으로 시간대를 알고 있는 것도 아니다.
        System.out.println("=============================");
        System.out.println("현재시간 = " + now);
        System.out.println("date = " + date);
    }

    @Test
    void calendar() {
        Date now = Calendar.getInstance().getTime();

        // Date 의 여러 문제점으로 인해 Calendar 가 등장하며 Date 의 여러 메서드들이 deprecate 되었다.
        // 하지만 역시 쉽게 에러를 일으키는 구조를 가지고 있으며, 달의 인덱스도 여전히 0부터 시작한다.
        // 게다가 DateFormat 같은 일부 기능은 Date 에서만 작동한다. DateFormat 은 스레드에 안전하지 않은 문제점도 갖고 있다.
        // 즉, 두 스레드가 동시에 하나의 포매터로 날짜를 파싱할 때 예기치 못한 결과가 일어날 수 있다.
        // 또한 여전히 가변클래스이기 때문에 유지보수가 어렵다.
        System.out.println("=============================");
        System.out.println("now = " + now);
    }

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
        LocalDate parseDate = LocalDate.parse("2021-01-01");
        LocalTime parseTime = LocalTime.parse("14:24:31");
        LocalDateTime dateTime = LocalDateTime.of(parseDate, parseTime);
        LocalDateTime dateTime1 = parseDate.atTime(parseTime);
        LocalDateTime dateTime2 = parseTime.atDate(parseDate);

        int dayOfYear = date.getDayOfYear();
        int dayOfMonth = date.getDayOfMonth();
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        Month month = date.getMonth();
        int monthValue = date.getMonthValue();
        int lengthOfMonth = localDate.lengthOfMonth();  // 달의 일수
        boolean leapYear = localDate.isLeapYear();  // 윤년인지?

        // 특정 시간대 적용
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        ZonedDateTime systemDefaultTime = date.atZone(ZoneId.systemDefault());
        LocalDateTime utc = LocalDateTime.now(ZoneId.of("UTC"));
        ZoneId parisZone = ZoneId.of("Europe/Paris");
        ZonedDateTime parisTime = LocalDateTime.now(parisZone)
                .atZone(parisZone);

        // 초정밀 시간제어
        // 기계 전용의 유틸리티
        Instant.ofEpochSecond(3);
        Instant.ofEpochSecond(3, 0);
        Instant.ofEpochSecond(2, 1_000_000_000);  // 2초 이후의 1억 나노초 (1초)
        Instant.ofEpochSecond(4, -1_000_000_000);  // 4초 이전의 1억 나노초 (1초)

        // 기간 - Durations, Period
        Period tenDays = Period.between(LocalDate.of(2021, 1, 1), LocalDate.of(2021, 1, 11));

        // 좀 더 복잡한 날짜 조정
        LocalDate date1 = LocalDate.of(2021, 10, 14);
        LocalDate date2 = date1.with(nextOrSame(DayOfWeek.SUNDAY));
        LocalDate date3 = date2.with(lastDayOfMonth());

        // ZoneId 를 사용해서 Instant 를 LocalDateTime 으로 바꿀 수 있다.
        // 기존의 Date 클래스를 처리하는 코드를 사용해야하는 상황이 있을 수 있으므로 Instant 로 작업하는 것이 유리하다.
        Instant instant = Instant.now();
        LocalDateTime timeFormInstant = LocalDateTime.ofInstant(instant, parisZone);

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
        System.out.println("tenDays = " + tenDays);
        System.out.println("=============================");
        System.out.println("date1 = " + date1);
        System.out.println("date1 과 같거나 이후의 일요일 = " + date2);
        System.out.println("10월의 마지막 날 = " + date3);
        System.out.println("=============================");
        System.out.println("timeFormInstant = " + timeFormInstant);
    }

}
