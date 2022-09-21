package domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.generator.BuilderArbitraryGenerator;
import net.jqwik.api.Arbitraries;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    private final FixtureMonkey fixtureMonkey = FixtureMonkey.builder()
            .defaultGenerator(BuilderArbitraryGenerator.INSTANCE)
            .build();

    @Test
    void createLottoNumber() {
        LottoNumber lottoNumber = fixtureMonkey.giveMeOne(LottoNumber.class);

        System.out.println("lottoNumber: " + lottoNumber);

        assertThat(lottoNumber).isNotNull();
    }

    @RepeatedTest(10000)
    void between1to45() {
        LottoNumber number = fixtureMonkey.giveMeBuilder(LottoNumber.class)
                .set("number", Arbitraries.integers().between(1, 45))
                .sample();

        assertThat(number).isGreaterThan(LottoNumber.of(0));
        assertThat(number).isLessThan(LottoNumber.of(46));
    }

}
