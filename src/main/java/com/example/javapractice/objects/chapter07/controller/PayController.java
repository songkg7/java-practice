package com.example.javapractice.objects.chapter07.controller;

import com.example.javapractice.objects.chapter07.model.Employee;
import com.example.javapractice.objects.chapter07.model.HourlyEmployee;
import com.example.javapractice.objects.chapter07.model.SalariedEmployee;
import com.example.javapractice.objects.chapter07.view.InputView;
import com.example.javapractice.objects.chapter07.view.OutputView;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class PayController {

    private final InputView inputView;
    private final OutputView outputView;

    public void run() {
        // 사용자로부터 소득세율을 입력받는다.
        double taxRate = getTaxRate();

        // 직원의 급여를 계산한다.
        Employee salariedEmployee = SalariedEmployee.of("직원A", 400);
        double salary = salariedEmployee.calculatePay(taxRate);

        HourlyEmployee hourlyEmployee = HourlyEmployee.of("계약직 직원B", 1, 160);
        double temporaryPay = hourlyEmployee.calculatePay(taxRate);

        // 양식에 맞게 결과를 출력한다.
        outputView.describeResult(salariedEmployee.getName(), salary);
        outputView.describeResult(hourlyEmployee.getName(), temporaryPay);
    }

    private double getTaxRate() {
        outputView.requestTaxRate();
        return inputView.inputTaxRate();
    }

}
