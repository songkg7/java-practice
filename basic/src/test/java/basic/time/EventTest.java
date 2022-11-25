package basic.time;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.time.ZonedDateTime;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class EventTest {

    @Test
    void equals() {
        ZonedDateTime time1 = ZonedDateTime.parse("2021-10-10T10:00:00+09:00[Asia/Seoul]");
        ZonedDateTime time2 = ZonedDateTime.parse("2021-10-10T01:00:00Z[UTC]");

        Event event1 = new Event("event", time1);
        Event event2 = new Event("event", time2);

        assertThat(event1.equals(event2)).isTrue();
        assertThat(event1).isEqualTo(event2);
    }

}
