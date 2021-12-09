package com.example.test.effectivejava.item45;

import static java.math.BigInteger.TWO;

import java.math.BigInteger;
import java.util.stream.Stream;

public class MersennePrime {

    public static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }

}
