package basic.time;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.temporal.WeekFields;
import org.junit.jupiter.api.DisplayName;
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

    @Test
    void compareZonedDateTimeToLocalDateTime() {
        ZonedDateTime seoulZonedTime = ZonedDateTime.parse("2021-10-10T10:00:00+09:00[Asia/Seoul]");
        ZonedDateTime utcTime = ZonedDateTime.parse("2021-10-10T01:00:00Z[UTC]");

        boolean b1 = seoulZonedTime.equals(utcTime);// false
        assertThat(b1).isFalse();
    }

    @Test
    void compareZonedDateTimeToLocalDateTime_2() {
        ZonedDateTime seoulZonedTime = ZonedDateTime.parse("2021-10-10T10:00:00+09:00[Asia/Seoul]");
        ZonedDateTime utcTime = ZonedDateTime.parse("2021-10-10T01:00:00Z[UTC]");

        // ChronoZonedDateTimeByInstantComparator 에 의해 timeLineOrder 가 호출되며 비교된다.
        assertThat(seoulZonedTime).isEqualTo(utcTime);
    }

    @Test
    @DisplayName("UTC 를 변경하려는 ZoneId 의 LocalDateTime 을 가지도록 변경한다.")
    void withZoneSameInstant() {
        ZonedDateTime seoulZonedTime = ZonedDateTime.parse("2021-10-10T10:00:00+09:00[Asia/Seoul]");
        ZonedDateTime utcTime = ZonedDateTime.parse("2021-10-10T01:00:00Z[UTC]");

        ZonedDateTime seoulZonedTime2 = utcTime.withZoneSameInstant(seoulZonedTime.getZone());
        System.out.println("seoulZonedTime: " + seoulZonedTime);
        System.out.println("utcTime: " + utcTime);
        System.out.println("seoulZonedTime by UTC: " + seoulZonedTime2);
        assertThat(seoulZonedTime).isEqualTo(seoulZonedTime2);
    }

    @Test
    @DisplayName("UTC ZonedTime 의 LocalDateTime 을 유지한채로 ZoneId 를 변경한다.")
    void withZoneSameLocal() {
        ZonedDateTime seoulZonedTime = ZonedDateTime.parse("2021-10-10T10:00:00+09:00[Asia/Seoul]");
        ZonedDateTime utcTime = ZonedDateTime.parse("2021-10-10T01:00:00Z[UTC]");

        ZonedDateTime seoulZonedTime2 = utcTime.withZoneSameLocal(seoulZonedTime.getZone());
        System.out.println("seoulZonedTime: " + seoulZonedTime);
        System.out.println("utcTime: " + utcTime);
        System.out.println("seoulZonedTime by UTC: " + seoulZonedTime2);
        assertThat(seoulZonedTime).isNotEqualTo(seoulZonedTime2);
    }

}
