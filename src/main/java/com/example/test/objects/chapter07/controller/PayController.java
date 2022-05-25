package com.example.test.objects.chapter07.controller;

import com.example.test.objects.chapter07.model.ContractWorker;
import com.example.test.objects.chapter07.model.Employee;
import com.example.test.objects.chapter07.model.TemporaryWorker;
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
        Employee contractWorker = ContractWorker.of("직원A", 400);
        double contractPay = contractWorker.calculatePay(taxRate);

        TemporaryWorker temporaryWorker = TemporaryWorker.of("계약직 직원B", 1);
        temporaryWorker.working(160);
        double temporaryPay = temporaryWorker.calculatePay(taxRate);

        // 양식에 맞게 결과를 출력한다.
        outputView.describeResult(contractWorker.getName(), contractPay);
        outputView.describeResult(temporaryWorker.getName(), temporaryPay);
    }

    private double getTaxRate() {
        outputView.requestTaxRate();
        return inputView.inputTaxRate();
    }

}
