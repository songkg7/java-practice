package effectivejava.item45;

import static effectivejava.item45.MersennePrime.primes;
import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

import org.junit.jupiter.api.Test;

class MersennePrimeTest {

    @Test
    void test_1() {
        primes().map(prime -> TWO.pow(prime.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(50))
                .limit(20)
                .forEach(mp -> System.out.println(mp.bitLength() + ": " + mp));
    }

}