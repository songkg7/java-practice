package basicsyntax.ais;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AisParserTest {

    @Test
    @DisplayName("1645315200 은 2022년 2월 20일 00시 00분이다.")
    void time() {
        Instant instant = Instant.ofEpochSecond(1645315200);
        LocalDateTime expected = LocalDateTime.of(2022, 2, 20, 0, 0);
        LocalDateTime actual = LocalDateTime.ofInstant(instant, ZoneId.of("UTC"));

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void bit16() {
        int i = Integer.parseInt("58", 16); // 16진수를 10진수로 변환
        int j = Integer.parseInt("101", 2); // 2진수를 10진수로 변환

        System.out.println("i: " + i);
        System.out.println("j: " + j);
    }
}
