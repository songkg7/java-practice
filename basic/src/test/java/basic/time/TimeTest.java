package basic.time;

import java.time.ZonedDateTime;
import org.junit.jupiter.api.Test;

public class TimeTest {

    @Test
    void zoneDateTime() {
        ZonedDateTime now = ZonedDateTime.now();

        System.out.println("now: " + now);
    }
}
