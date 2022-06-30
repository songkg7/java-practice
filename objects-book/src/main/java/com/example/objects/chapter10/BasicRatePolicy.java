package com.example.objects.chapter10;

import com.example.objects.chapter01.movie.domain.Money;
import com.example.objects.chapter10.domain.Call;
import com.example.objects.chapter10.domain.Phone;

public abstract class BasicRatePolicy implements RatePolicy {

    @Override
    public Money calculateFee(Phone phone) {
        Money result = Money.ZERO;

        for (Call call : phone.getCalls()) {
            result = result.plus(calculateCallFee(call));
        }

        return result;
    }

    abstract protected Money calculateCallFee(Call call);
}
