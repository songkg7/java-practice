package com.example.test.objects.chapter07.view;

import java.io.PrintStream;

public class OutputView {

    private final PrintStream printStream;

    public OutputView(PrintStream printStream) {
        this.printStream = printStream;
    }

    public void requestTaxRate() {
        printStream.println("세율을 입력하세요.");
    }

    public void describeResult(String name, double pay) {
        printStream.println("이름: " + name + ", 급여: " + pay);
    }
}
