package com.example.objects.chapter10;

import com.example.objects.chapter01.movie.domain.Money;
import com.example.objects.chapter10.domain.Call;
import com.example.objects.chapter10.domain.Phone;
import java.util.ArrayList;
import java.util.List;

public class BasicRatePolicy implements RatePolicy {

    private List<FeeRule> feeRules = new ArrayList<>();

    public BasicRatePolicy(FeeRule... feeRules) {
        this.feeRules = List.of(feeRules);
    }

    @Override
    public Money calculateFee(Phone phone) {
        return phone.getCalls()
                .stream()
                .map(this::calculate)
                .reduce(Money.ZERO, Money::plus);
    }

    private Money calculate(Call call) {
        return feeRules.stream()
                .map(rule -> rule.calculateFee(call))
                .reduce(Money.ZERO, Money::plus);
    }
}
