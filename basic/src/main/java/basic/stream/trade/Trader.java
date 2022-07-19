package basic.stream.trade;

import lombok.Value;

@Value(staticConstructor = "of")
public class Trader {

    String name;
    City city;

}
