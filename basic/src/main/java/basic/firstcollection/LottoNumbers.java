package basic.firstcollection;

import java.util.Iterator;
import java.util.List;

public class LottoNumbers implements Iterable<LottoNumber> {

    private final List<LottoNumber> lottoNumbers;

    private LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public static LottoNumbers create(LottoNumber... numbers) {
        return new LottoNumbers(List.of(numbers));
    }

    public boolean isEmpty() {
        return lottoNumbers.isEmpty();
    }

    @Override
    public Iterator<LottoNumber> iterator() {
        return lottoNumbers.iterator();
    }
}
