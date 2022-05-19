package com.example.test.objects.chapter07.controller;

import com.example.test.objects.chapter07.model.Employee;
import com.example.test.objects.chapter07.view.InputView;
import com.example.test.objects.chapter07.view.OutputView;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PayController {

    private final InputView inputView;
    private final OutputView outputView;

    public void run() {
        // 사용자로부터 소득세율을 입력받는다.
        double taxRate = getTaxRate();

        // 직원의 급여를 계산한다.
        Employee employee = Employee.of("직원A", 400);
        double pay = employee.calculatePay(taxRate);

        // 양식에 맞게 결과를 출력한다.
        outputView.describeResult(employee.getName(), pay);
    }

    private double getTaxRate() {
        outputView.requestTaxRate();
        return inputView.inputTaxRate();
    }

}
