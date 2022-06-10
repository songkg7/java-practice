package com.example.javapractice.designpattern.chainofresponsibility;

import com.example.javapractice.designpattern.chainofresponsibility.dispenser.Currency;
import com.example.javapractice.designpattern.chainofresponsibility.dispenser.DispenseChain;
import com.example.javapractice.designpattern.chainofresponsibility.dispenser.Won100Dispenser;
import com.example.javapractice.designpattern.chainofresponsibility.dispenser.Won10Dispenser;
import com.example.javapractice.designpattern.chainofresponsibility.dispenser.Won1Dispenser;
import com.example.javapractice.designpattern.chainofresponsibility.filterchain.FilterChain;
import com.example.javapractice.designpattern.chainofresponsibility.filterchain.PasswordValidationFilter;
import com.example.javapractice.designpattern.chainofresponsibility.filterchain.SignUpForm;
import com.example.javapractice.designpattern.chainofresponsibility.filterchain.UsernameValidationFilter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChainOfResponsibilityTest {

    private DispenseChain chain1 = new Won100Dispenser();
    private FilterChain filterChain = new UsernameValidationFilter();

    @BeforeEach
    void init() {
        this.chain1 = new Won100Dispenser();
        DispenseChain chain2 = new Won10Dispenser();
        DispenseChain chain3 = new Won1Dispenser();

        chain1.setNextChain(chain2);
        chain2.setNextChain(chain3);

        this.filterChain = new UsernameValidationFilter();
        filterChain.setNext(new PasswordValidationFilter());

    }

    @Test
    void test_1() {
        chain1.dispense(new Currency(378));
    }

    @Test
    void test_2() {
        SignUpForm signUpForm = new SignUpForm("test1", "1234");

        filterChain.doFilter(signUpForm);
    }

}