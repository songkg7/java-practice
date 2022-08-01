package com.example.objects.chapter10;

import com.example.objects.chapter10.domain.Call;
import com.example.objects.chapter10.domain.DateTimeInterval;
import java.util.List;

public class FixedFeeCondition implements FeeCondition {

    // NOTE:
    // 개념적으로는 불필요한 클래스를 추가하고 반환 타입이 List 임에도 항상 단 하나의 인스턴스를 반환한다는 사실이 마음에 조금 걸리지만
    // 개념적 무결성을 무너뜨리는 것보다는 약간의 부조화를 수용하는 편이 더 낫다. - p510
    @Override
    public List<DateTimeInterval> findTimeIntervals(Call call) {
        return List.of(call.getInterval());
    }
}
