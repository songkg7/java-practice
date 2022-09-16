package basic.random;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class RandomTest {

    private MultiValueMap<Integer, Integer> integerMap = new LinkedMultiValueMap<>();
    private MultiValueMap<String, String> stringMap = new LinkedMultiValueMap<>();

    @Test
    void test() {
        long count = IntStream.range(0, 100000)
                .mapToObj(i -> ThreadLocalRandom.current().nextInt(1, 10))
                .count();

        assertThat(count).isEqualTo(100000);
    }

    @RepeatedTest(100)
    void test_1() {
        IntStream.range(0, 100000)
                .mapToObj(i -> ThreadLocalRandom.current().nextInt(1, 10))
                .forEach(i -> integerMap.add(i, i));

        long count = integerMap.values().stream()
                .mapToLong(Collection::size)
                .sum();

        assertThat(count).isEqualTo(100000);
    }

    @RepeatedTest(100)
    @DisplayName("Math.random 이 stream 내부에서 문제가 있는지 확인")
    void test_2() {
        IntStream.range(0, 100000)
                .mapToObj(i -> (int) (Math.random() * 10))
                .forEach(i -> stringMap.add(String.valueOf(i), String.valueOf(i)));

        long count = stringMap.values().stream()
                .mapToLong(Collection::size)
                .sum();

        System.out.println(stringMap.size());
        int size = stringMap.get("1").size();
        System.out.println("one: " + size);


        assertThat(count).isEqualTo(100000);
    }

}
