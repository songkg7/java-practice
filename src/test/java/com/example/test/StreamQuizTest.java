package com.example.test;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

// 문제 출처 : https://mangkyu.tistory.com/116
public class StreamQuizTest {

    @Nested
    class Quiz1Test {

        List<String[]> csvLines;

        @BeforeEach
        void setUp() throws CsvException, IOException {
            @SuppressWarnings("ConstantConditions")
            CSVReader csvReader = new CSVReader(new FileReader(getClass().getResource("/User.csv").getFile()));

            csvReader.readNext();
            csvLines = csvReader.readAll();
        }

        @Test
        @DisplayName("각 취미를 선호하는 인원이 몇 명인지 계산하라")
        void quiz_1() {
            Map<String, Integer> result = new HashMap<>();
            csvLines.stream()
                    .map(line -> line[1].replaceAll("\\s", ""))
                    .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
                    .forEach(hobby -> result.merge(hobby, 1, (oldValue, newValue) -> newValue += oldValue));

            result.keySet().forEach(v -> System.out.println(v + ": " + result.get(v)));
        }

        @Test
        @DisplayName("각 취미를 선호하는 정씨성을 가진 인원이 몇 명인지 계산하라")
        void quiz_2() {
            Map<String, Integer> result = new HashMap<>();
            csvLines.stream()
                    .filter(line -> line[0].startsWith("정"))
                    .map(line -> line[1].replaceAll("\\s", ""))
                    .flatMap(hobbies -> Arrays.stream(hobbies.split(":")))
                    .forEach(hobby -> result.merge(hobby, 1, (oldValue, newValue) -> newValue += oldValue));

            result.keySet().forEach(v -> System.out.println(v + ": " + result.get(v)));
        }


        @Test
        @DisplayName("소개 내용에 '좋아'가 몇 번 등장하는지 구하여라")
        void quiz_3() {
            long result = csvLines.stream()
                    .map(line -> countContains(line[2], 0))
                    .reduce(0, Integer::sum);
            System.out.println("result = " + result);
        }

        private int countContains(String src, int fromIndex) {
            String target = "좋아";
            int index = src.indexOf(target, fromIndex);
            if (index >= 0) {
                return 1 + countContains(src, index + target.length());
            }
            return 0;
        }

    }

    @Nested
    class Quiz2Test {

        private final List<String> WORDS = List.of("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

        @Test
        @DisplayName("List 에 저장된 단어들의 접두사가 각각 몇개씩 있는지 Map<String, Integer> 로 반환하여라")
        void test_1() {
            Map<String, Integer> result = new HashMap<>();
            WORDS.stream()
                    .map(s -> s.split(""))
                    .forEach(word -> result.merge(word[0], 1, (oldValue, newValue) -> newValue += oldValue));

            result.keySet().forEach(v -> System.out.println(v + ": " + result.get(v)));
        }

        @Test
        @DisplayName("List 에 저장된 단어들 중 길이가 2 이상인 경우에만, 모든 단어를 대문자로 변환하여 스페이스로 구분한 하나의 문자열로 합한 결과를 반환하라")
        void test_2() {
            String result = WORDS.stream()
                    .filter(word -> word.length() >= 2)
                    .map(String::toUpperCase)
                    .map(s -> s.substring(0, 1))
                    .collect(joining(" "));

            System.out.println("result = " + result);
        }

    }

    @Nested
    class Quiz3Test {

        private final List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        private final List<Integer> numbers2 = Arrays.asList(3, 4);

        @Test
        @DisplayName("두 리스트의 모든 숫자 조합을 출력하라")
        void quiz_1() {
            List<Integer[]> nums = numbers1.stream()
                    .flatMap(i -> numbers2.stream().map(j -> new Integer[]{ i, j }))
                    .collect(toList());

            nums.forEach(a -> System.out.println(Arrays.toString(a)));
        }

        @Test
        @DisplayName("모든 숫자 조합의 곱 중 가장 큰 값을 출력하라")
        void quiz_2() {
            int result = numbers1.stream()
                    .flatMap(i -> numbers2.stream().map(j -> new Integer[]{ i, j }))
                    .mapToInt(a -> multiply(a[0], a[1]))
                    .max()
                    .getAsInt();

            System.out.println("result = " + result);
        }

        private int multiply(int a, int b) {
            return a * b;
        }

    }

}
