package com.example.javapractice.basic.stream.dicegame;

import java.util.concurrent.ThreadLocalRandom;
import lombok.Getter;
import lombok.Value;

@Value(staticConstructor = "of")
public class Dice {

     enum Point {
        ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6);

        @Getter
        final int value;

        Point(int value) {
            this.value = value;
        }
     }

    Point point;

    public static Dice newInstance() {
        return new Dice(Point.ONE);
    }

    public Dice casting() {
        return new Dice(Point.values()[ThreadLocalRandom.current().nextInt(0, 6)]);
    }

}
