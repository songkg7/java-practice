package com.example.test.regex;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RegexTest {

    @Test
    void test() {
        String s = "arou1nd3";
        String result = s.replaceAll("\\d", "");

        assertThat(result).isEqualTo("around");
    }
}
