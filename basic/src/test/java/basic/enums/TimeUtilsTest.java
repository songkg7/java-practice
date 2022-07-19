package basic.enums;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class TimeUtilsTest {

    @Test
    void test() {
        String timeString = "202201010000";

        LocalDateTime localDateTime = LocalDateTime.parse(timeString, TimeUtils.LOCAL_DATE_TIME.formatter());
        LocalDateTime parseTime = TimeUtils.parseLocalDateTime(timeString);

        assertThat(localDateTime).isEqualTo(parseTime);
    }

    @Test
    void format() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();

        String format1 = TimeUtils.format(localDate);
        String format2 = TimeUtils.format(localDateTime);

        System.out.println("format1: " + format1);
        System.out.println("format2: " + format2);
    }

    @Test
    void lambdaFormat() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = LocalDate.now();

        String format1 = TimeUtils.LOCAL_DATE.formatByLambda(localDate);
        String format2 = TimeUtils.LOCAL_DATE_TIME.formatByLambda(localDateTime);

        System.out.println("format1: " + format1);
        System.out.println("format2: " + format2);
    }
}
