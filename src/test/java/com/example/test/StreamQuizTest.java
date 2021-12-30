package com.example.test;

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
import org.junit.jupiter.api.Test;

// 문제 출처 : https://mangkyu.tistory.com/116
public class StreamQuizTest {

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
