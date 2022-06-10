package com.example.javapractice.objects.chapter07.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public double inputTaxRate() {
        return scanner.nextDouble();
    }

}
