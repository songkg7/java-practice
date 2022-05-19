package com.example.test.objects.chapter07.view;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.ByteArrayInputStream;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Test
    void inputTaxRate() {
        // given
        InputView inputView = createInputView("23.5");

        // when
        double taxRate = inputView.inputTaxRate();

        // then
        assertThat(taxRate).isEqualTo(23.5);
    }

    private InputView createInputView(String input) {
        return new InputView(new Scanner(new ByteArrayInputStream(input.getBytes())));
    }
}