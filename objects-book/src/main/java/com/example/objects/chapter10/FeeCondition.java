package com.example.objects.chapter10;

import com.example.objects.chapter10.domain.Call;
import com.example.objects.chapter10.domain.DateTimeInterval;
import java.util.List;

public interface FeeCondition {

    List<DateTimeInterval> findTimeIntervals(Call call);

}
