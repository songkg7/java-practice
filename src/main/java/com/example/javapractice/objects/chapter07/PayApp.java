package com.example.javapractice.objects.chapter07;

import com.example.javapractice.objects.chapter07.controller.PayController;
import com.example.javapractice.objects.chapter07.view.InputView;
import com.example.javapractice.objects.chapter07.view.OutputView;
import java.util.Scanner;

// 직원의 급여를 계산한다.
public class PayApp {
    public static void main(String[] args) {
        PayController payController = new PayController(new InputView(new Scanner(System.in)), new OutputView(System.out));
        payController.run();
    }
}
