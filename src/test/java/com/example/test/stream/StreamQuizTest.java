package com.example.test.stream;

import static com.example.test.basic.stream.trade.City.BUSAN;
import static com.example.test.basic.stream.trade.City.GYEONG_GI;
import static com.example.test.basic.stream.trade.City.INCHEAN;
import static com.example.test.basic.stream.trade.City.SEOUL;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toList;

import com.example.test.basic.stream.Student;
import com.example.test.basic.stream.dicegame.Dice;
import com.example.test.basic.stream.dicegame.Game;
import com.example.test.basic.stream.trade.City;
import com.example.test.basic.stream.trade.Trader;
import com.example.test.basic.stream.trade.Transaction;
import com.example.test.objects.chapter01.movie.domain.Money;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.Year;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
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
            @SuppressWarnings("OptionalGetWithoutIsPresent")
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
        @DisplayName("모든 거래 내역 중에서 최댓값과 최솟값을 구하라.")
        void quiz_7() {
            BigDecimal maxValue = transactions.stream()
                    .map(transaction -> transaction.getMoney().getAmount())
                    .max(Comparator.naturalOrder())
                    .orElse(BigDecimal.ZERO);

            BigDecimal minValue = transactions.stream()
                    .map(transaction -> transaction.getMoney().getAmount())
                    .min(Comparator.naturalOrder())
                    .orElse(BigDecimal.ZERO);

            System.out.println("maxValue = " + maxValue);
            System.out.println("minValue = " + minValue);
        }

    }

    @Nested
    class Quiz5Test {

        private final String[] strings = { "aaa", "bb", "c", "dddd" };

        @Test
        @DisplayName("모든 문자열의 길이를 더한 결과를 출력하라.")
        void quiz_1() {
            int result = Arrays.stream(strings)
                    .mapToInt(String::length)
                    .sum();

            System.out.println("result = " + result);
        }

        @Test
        @DisplayName("가장 긴 것의 길이를 출력하라.")
        void quiz_2() {
            @SuppressWarnings("OptionalGetWithoutIsPresent")
            int result = Arrays.stream(strings)
                    .mapToInt(String::length)
                    .max()
                    .getAsInt();

            System.out.println("result = " + result);
        }

        @Test
        @DisplayName("중복되지 않는 임의의 로또번호(1~45) 6개를 출력하라.")
        void quiz_3() {
            List<Integer> result = ThreadLocalRandom.current().ints(1, 46)
                    .distinct()
                    .limit(6)
                    .boxed()
                    .collect(toList());

            System.out.println("result = " + result);
        }

        @Test
        @DisplayName("두 개의 주사위를 굴려서 나온 눈의 합이 6인 경우를 모두 출력하라. 주사위는 총 20번 던진다. 이 주사위 게임을 설계하여라.")
        void quiz_4() {
            Game.ready(Dice.newInstance(), Dice.newInstance())
                    .play()
                    .printResult();
        }

        @Test
        @DisplayName("special. primeNumber")
        void quiz_5() {

        }

    }

    @Nested
    class Quiz6Test {

        private final List<Student> students = List.of(
                Student.of("나자바", true, 1, 1, 300),
                Student.of("김지미", false,1, 1, 250),
                Student.of("김자바", true, 1, 1, 200),
                Student.of("이지미", false, 1, 2, 150),
                Student.of("남자바", true, 1, 2, 100),
                Student.of("안지미", false, 1, 2, 50),
                Student.of("황지미", false, 1, 3, 100),
                Student.of("강지미", false, 1, 3, 150),
                Student.of("이자바", true, 1, 3, 200),
                Student.of("나자바", true, 2, 1, 300),
                Student.of("김지미", false, 2, 1, 250),
                Student.of("김자바", true, 2, 1, 200),
                Student.of("이지미", false, 2, 2, 150),
                Student.of("남자바", true, 2, 2, 100),
                Student.of("안지미", false, 2, 2, 50),
                Student.of("황지미", false, 2, 3, 100),
                Student.of("강지미", false, 2, 3, 150),
                Student.of("이자바", true, 2, 3, 200));

        @Test
        @DisplayName("불합격(150점 미만)한 학생의 수를 남자와 여자로 구분하라.")
        void quiz_1() {
            Map<Boolean, List<Student>> result = students.stream()
                    .filter(student -> student.getScore() < 150)
                    .collect(groupingBy(Student::isMale));

            System.out.println("result = " + result);
        }

        @Test
        @DisplayName("각 반별 총점을 학년 별로 나누어 구하라.")
        void quiz_2() {
            Map<Integer, Map<Integer, Integer>> result = students.stream()
                    .collect(groupingBy(Student::getGrade,
                            groupingBy(Student::getClazz, summingInt(Student::getScore))));

            System.out.println("result = " + result);
        }

    }

}
