package com.example.test;

import static com.example.test.basic.stream.City.BUSAN;
import static com.example.test.basic.stream.City.GYEONG_GI;
import static com.example.test.basic.stream.City.INCHEAN;
import static com.example.test.basic.stream.City.SEOUL;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import com.example.test.basic.stream.City;
import com.example.test.basic.stream.Trader;
import com.example.test.basic.stream.Transaction;
import com.example.test.objects.chapter01.movie.domain.Money;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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

        @Nested
        class Quiz4Test {

            List<Transaction> transactions = new ArrayList<>();

            @BeforeEach
            void setUp() {
                Trader kyu = Trader.of("Kyu", SEOUL);
                Trader ming = Trader.of("Ming", GYEONG_GI);
                Trader hyuk = Trader.of("Hyuk", INCHEAN);
                Trader song = Trader.of("Song", SEOUL);

                transactions = List.of(Transaction.of(kyu, Year.of(2019), Money.wons(30000)),
                        Transaction.of(kyu, Year.of(2020), Money.wons(12000)),
                        Transaction.of(ming, Year.of(2020), Money.wons(40000)),
                        Transaction.of(ming, Year.of(2020), Money.wons(7100)),
                        Transaction.of(hyuk, Year.of(2019), Money.wons(5900)),
                        Transaction.of(song, Year.of(2020), Money.wons(4900)));
            }

            @Test
            @DisplayName("2020년에 일어난 모든 거래 내역을 찾아 거래값을 기준으로 오름차순 정렬하라.")
            void quiz_1() {
                List<Transaction> result = transactions.stream()
                        .filter(transaction -> transaction.getYear().equals(Year.of(2020)))
                        .sorted(Comparator.comparing(Transaction::getMoney).reversed())
                        .collect(toList());

                System.out.println("result = " + result);
            }

            @Test
            @DisplayName("거래 내역이 있는 거래자가 근무하는 모든 도시를 중복없이 나열하라.")
            void quiz_2() {
                List<City> result = transactions.stream()
                        .map(transaction -> transaction.getTrader().getCity())
                        .distinct()
                        .collect(toList());

                System.out.println("result = " + result);
            }

            @Test
            @DisplayName("서울에서 근무하는 모든 거래자를 찾아서 이름순서대로 정렬하라.")
            void quiz_3() {
                List<Trader> result = transactions.stream()
                        .map(Transaction::getTrader)
                        .filter(trader -> trader.getCity().equals(SEOUL))
                        .sorted(Comparator.comparing(Trader::getName))
                        .collect(toList());

                System.out.println("result = " + result);
            }

            @Test
            @DisplayName("모든 거래자의 이름을 순서대로 정렬하라.")
            void quiz_4() {
                transactions.stream()
                        .map(Transaction::getTrader)
                        .sorted(Comparator.comparing(Trader::getName))
                        .forEach(System.out::println);
            }

            @Test
            @DisplayName("부산에 거래자가 있는지를 확인하라.")
            void quiz_5() {
                boolean result = transactions.stream()
                        .map(Transaction::getTrader)
                        .anyMatch(trader -> trader.getCity().equals(BUSAN));

                System.out.println("result = " + result);
            }

            @Test
            @DisplayName("서울에 거주하는 거래자의 모든 거래 내역을 구하라.")
            void quiz_6() {
                List<Transaction> result = transactions.stream()
                        .filter(transaction -> transaction.getTrader().getCity().equals(SEOUL))
                        .collect(toList());

                System.out.println("result = " + result);
            }

            @Test
            @DisplayName("모든 거래 내역 중에서 최댓값과 최솟값을 구하라. 단, 최댓값은 reduce 를 이용하고 최솟값은 stream 의 min 을 이용하라.")
            void quiz_7() {

            }

        }


    }

}
