package basic.firstcollection;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class LottoNumbersTest {

    @Test
    void isEmpty() {
        LottoNumber lottoNumber = LottoNumber.create(7);
        LottoNumbers lottoNumbers = LottoNumbers.create(lottoNumber);

        assertThat(lottoNumbers.isEmpty()).isFalse();
    }

    @Test
    void isEmpty_iterable() {
        LottoNumber lottoNumber = LottoNumber.create(7);
        LottoNumbers lottoNumbers = LottoNumbers.create(lottoNumber);

        assertThat(lottoNumbers).containsExactly(lottoNumber);
        assertThat(lottoNumbers).isNotEmpty();
        assertThat(lottoNumbers).hasSize(1);
    }

    @Test
    void iterator() {
        LottoNumber lottoNumber1 = LottoNumber.create(1);
        LottoNumber lottoNumber2 = LottoNumber.create(2);
        LottoNumbers lottoNumbers = LottoNumbers.create(lottoNumber1, lottoNumber2);

        for (LottoNumber lottoNumber : lottoNumbers) {
            System.out.println("lottoNumber: " + lottoNumber);
        }
    }
}
