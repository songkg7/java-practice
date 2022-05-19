package com.example.test.objects.chapter07.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OutputViewTest {

    private OutputView outputView;
    private ByteArrayOutputStream outputStream;

    @BeforeEach
    void setUp() {
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        outputView = new OutputView(printStream);
    }

    @Test
    @DisplayName("세율을 입력받을 때는 '세율을 입력하세요' 라는 메세지가 출력된다.")
    void requestTaxRate() {
        outputView.requestTaxRate();

        assertThat(outputStream.toString()).contains("세율을 입력하세요.");
    }
}