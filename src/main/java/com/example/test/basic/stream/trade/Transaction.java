package com.example.test.basic.stream.trade;

import com.example.test.objects.chapter01.movie.domain.Money;
import java.time.Year;
import lombok.Value;

@Value(staticConstructor = "of")
public class Transaction {

    Trader trader;
    Year year;
    Money money;

}
