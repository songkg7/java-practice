package basic.stream;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StreamTest {

    @Test
    void flatMap() {
        Stream<String[]> strStream = Stream.of( new String[] {"a", "b", "c"}, new String[] {"d", "e", "f"});

        // map 을 사용하면 2중 스트림이 반환됨
        Stream<Stream<String>> streamStream = strStream.map(Arrays::stream);

        // flatMap 을 사용하면 1중 스트림으로 차원을 한 단계 낮출 수 있음
        Stream<String> stringStream = strStream.flatMap(Arrays::stream);
    }

    @Test
    void flatMap_2() {
        List<String> lists = Arrays.asList("Hello", "World");
        List<String[]> collect = lists.stream()
                .map(s -> s.split(""))
                .distinct()
                .collect(toList());

        System.out.println("collect = " + collect);
    }

    @Test
    void flatMap_3() {
        List<String> lists = Arrays.asList("Hello", "World");
        List<String> collect = lists.stream()
                .map(s -> s.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());

        System.out.println("collect = " + collect);
    }

    @Test
    void reduce() {
        List<Integer> lists = Arrays.asList(1, 2, 3, 4, 5);
        Integer result = lists.stream()
                .reduce(Integer::sum)
                .get();

        System.out.println("result = " + result);
    }

    @Test
    void reduce_1() {
        OptionalInt result = IntStream.range(1, 4)
                .reduce((a, b) -> {
                    return Integer.sum(a, b);
                });

        System.out.println("result = " + result);
    }

    @Test
    void reduce_2() {
        int result = IntStream.range(1, 4)
                .reduce(10, (a, b) -> {
                    return Integer.sum(a, b);
                });

        System.out.println("result = " + result);
    }

    @Test
    @DisplayName("병렬 처리가 아니면 combiner 는 실행되지 않는다.")
    void reduce_3() {
        Integer result = Stream.of(1, 2, 3)
                .reduce(10, Integer::sum, (a, b) -> {
                    System.out.println("Combiner was called.");
                    return a + b;
                });

        System.out.println("result = " + result);
    }

    @Test
    void reduce_4() {
        Integer result = Stream.of(1, 2, 3)
                .parallel()
                .reduce(10, Integer::sum, (a, b) -> {
                    System.out.println("Combiner was called.");
                    return a + b;
                });

        System.out.println("result = " + result);
    }

    @Test
    void stream() {
        Stream.of("a", "b", "c", "d", "e")
                .filter(s -> {
                    System.out.println("filter : " + s);
                    return true;
                })
                .forEach(s -> System.out.println("forEach : " + s));
    }

    @Test
    void stream_1() {
        Stream.of("a", "b", "c", "a", "e")
                .map(s -> {
                    System.out.println("map : " + s);
                    return s.toUpperCase();
                })
                .anyMatch(s -> {
                    System.out.println("anyMatch : " + s);
                    return s.startsWith("A");
                });
    }

    @Test
    @DisplayName("실행 순서에 대한 고려 - map 우선")
    void stream_7() {
        Stream.of("a", "b", "c", "d", "e")
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("A");
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }

    @Test
    @DisplayName("실행 순서에 대한 고려 - filter 우선")
    void stream_8() {
        Stream.of("a", "b", "c", "d", "e")
                .filter(s -> {
                    System.out.println("filter: " + s);
                    return s.startsWith("a");
                })
                .map(s -> {
                    System.out.println("map: " + s);
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.println("forEach: " + s));
    }

    @Test
    void parallelStream() {
        Arrays.asList("a", "b", "c", "d", "e").
                parallelStream()
                .filter(s -> {
                    System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
                    return s.toUpperCase();
                })
                .forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));
    }

    @Test
    @DisplayName("sort")
    void parallelStream_1() {
        Arrays.asList("a", "b", "c", "d", "e").
                parallelStream()
                .filter(s -> {
                    System.out.format("filter: %s [%s]\n", s, Thread.currentThread().getName());
                    return true;
                })
                .map(s -> {
                    System.out.format("map: %s [%s]\n", s, Thread.currentThread().getName());
                    return s.toUpperCase();
                }).sorted((s1, s2) -> {
                    System.out.format("sort: %s <> %s [%s]\n", s1, s2, Thread.currentThread().getName());
                    return s1.compareTo(s2);
                })
                .forEach(s -> System.out.format("forEach: %s [%s]\n", s, Thread.currentThread().getName()));
    }

    @Test
    void bypass_filter() {
        List<Boolean> booleans = List.of(true, false, true);
        List<Boolean> collect = booleans.stream()
                .filter(v -> v)
                .collect(toList());
        System.out.println("collect = " + collect);
    }
}
