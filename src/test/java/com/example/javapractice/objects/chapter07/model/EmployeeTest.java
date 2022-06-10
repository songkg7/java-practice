package com.example.javapractice.objects.chapter07.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EmployeeTest {

    @Test
    @DisplayName("세율을 입력받으면 급여가 계산된다.")
    void calculatePay() {
        Employee employee = SalariedEmployee.of("testEmployee", 100);
        double pay = employee.calculatePay(0.20);

        assertThat(pay).isEqualTo(80.0);
    }
}