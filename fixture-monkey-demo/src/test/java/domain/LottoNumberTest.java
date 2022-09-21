package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.generator.BuilderArbitraryGenerator;
import java.util.List;
import net.jqwik.api.Arbitraries;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    private final FixtureMonkey fixtureMonkey = FixtureMonkey.builder()
            .defaultGenerator(BuilderArbitraryGenerator.INSTANCE)
            .build();

    @Test
    void createLottoNumber() {
        LottoNumber lottoNumber = fixtureMonkey.giveMeBuilder(LottoNumber.class)
                .set("number", 1)
                .sample();

        System.out.println("lottoNumber: " + lottoNumber);

        assertThat(lottoNumber).isNotNull();
    }

    @RepeatedTest(1000)
    void between1to45() {
        LottoNumber number = fixtureMonkey.giveMeBuilder(LottoNumber.class)
                .set("number", Arbitraries.integers().between(1, 45))
                .sample();

        assertThat(number).isGreaterThanOrEqualTo(LottoNumber.of(1));
        assertThat(number).isLessThanOrEqualTo(LottoNumber.of(45));
    }

    @Test
    @DisplayName("범위를 벗어난 로또 번호는 IllegalArgumentException 발생")
    void outOfRange() {
        assertThatThrownBy(() -> LottoNumber.of(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("로또 번호는 1~45 사이의 숫자만 가능합니다.");
    }

    @Test
    @DisplayName("6개의 무작위 로또 번호 생성 검증")
    void createRandomLottoNumbers() {
        List<LottoNumber> lottoNumbers = fixtureMonkey.giveMeBuilder(LottoNumber.class)
                .set("number", Arbitraries.integers().between(1, 45))
                .sampleList(6);

        assertThat(lottoNumbers).hasSize(6);
    }
}
