package domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.generator.BuilderArbitraryGenerator;
import org.junit.jupiter.api.Test;

class LottoNumberTest {

    @Test
    void createLottoNumber() {
        FixtureMonkey fixtureMonkey = FixtureMonkey.builder()
                .defaultGenerator(BuilderArbitraryGenerator.INSTANCE)
                .build();
        LottoNumber lottoNumber = fixtureMonkey.giveMeOne(LottoNumber.class);

        System.out.println("lottoNumber: " + lottoNumber);

        assertThat(lottoNumber).isNotNull();
    }

}
