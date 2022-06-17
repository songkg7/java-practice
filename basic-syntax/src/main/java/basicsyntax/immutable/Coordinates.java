package basicsyntax.immutable;

import lombok.Value;

@Value(staticConstructor = "of")
public class Coordinates {
    double longitude;
    double latitude;
}
