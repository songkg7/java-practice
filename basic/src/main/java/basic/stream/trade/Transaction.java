package basic.stream.trade;

import basic.stream.Money;
import java.time.Year;
import lombok.Value;

@Value(staticConstructor = "of")
public class Transaction {

    Trader trader;
    Year year;
    Money money;

}
