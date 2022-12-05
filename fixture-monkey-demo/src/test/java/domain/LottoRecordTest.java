package domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.navercorp.fixturemonkey.LabMonkey;
import com.navercorp.fixturemonkey.api.introspector.ConstructorPropertiesArbitraryIntrospector;
import com.navercorp.fixturemonkey.javax.validation.plugin.JavaxValidationPlugin;
import org.junit.jupiter.api.RepeatedTest;

class LottoRecordTest {

    private final LabMonkey fixture = LabMonkey.labMonkeyBuilder()
            .objectIntrospector(ConstructorPropertiesArbitraryIntrospector.INSTANCE)
            .plugin(new JavaxValidationPlugin())
            .build();

    @RepeatedTest(100)
    void shouldBetween1to45() {
        LottoRecord lottoRecord = fixture.giveMeOne(LottoRecord.class);

        assertThat(lottoRecord.number()).isBetween(1, 45);
    }
}
