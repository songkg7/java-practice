package com.example.test.objects.chapter10;

import com.example.test.objects.chapter01.movie.domain.Money;
import java.time.Duration;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class NightlyDiscountPhone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private final Money amount;
    private final Duration seconds;
    private final List<Call> calls;

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                result = result.plus(
                        nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            } else {
                result = result.plus(
                        amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            }
        }

        return result;
    }
}
