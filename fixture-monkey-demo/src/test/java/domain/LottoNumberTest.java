package domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.generator.BuilderArbitraryGenerator;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
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

    @Test
    void reflection() throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?>[] declaredConstructors = LottoNumber.class.getDeclaredConstructors();

        for (Constructor<?> declaredConstructor : declaredConstructors) {
            System.out.println("declaredConstructor: " + declaredConstructor);
            declaredConstructor.setAccessible(true);
            Class<?>[] parameterTypes = declaredConstructor.getParameterTypes();
            System.out.println("parameterTypes: " + parameterTypes);

            for (Class<?> parameterType : parameterTypes) {
                System.out.println("parameterType: " + parameterType);
                parameterType.getName();
            }
        }


    }

}
