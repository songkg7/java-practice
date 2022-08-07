package basic.assertion;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoneyTest {

    @Test
    @DisplayName("정상 생성 검증")
    void of() {
        Money money = Money.of(3000L);

        assertThat(money).isNotNull();
    }

    @Test
    @DisplayName("amount 가 음수일 경우 Money 생성 불가")
    void negative() {
        assertThatThrownBy(() -> Money.of(-3000L))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
