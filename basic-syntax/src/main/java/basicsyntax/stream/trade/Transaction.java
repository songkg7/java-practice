package basicsyntax.stream.trade;

import basicsyntax.stream.Money;
import java.time.Year;
import lombok.Value;

@Value(staticConstructor = "of")
public class Transaction {

    Trader trader;
    Year year;
    Money money;

}
