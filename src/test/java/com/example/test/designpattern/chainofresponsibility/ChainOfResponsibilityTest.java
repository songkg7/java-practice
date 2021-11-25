package com.example.test.designpattern.chainofresponsibility;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ChainOfResponsibilityTest {

    private DispenseChain chain1 = new Won100Dispenser();

    @BeforeEach
    void init() {
        this.chain1 = new Won100Dispenser();
        DispenseChain chain2 = new Won10Dispenser();
        DispenseChain chain3 = new Won1Dispenser();

        chain1.setNextChain(chain2);
        chain2.setNextChain(chain3);
    }

    @Test
    void test_1() {
        chain1.dispense(new Currency(378));
    }

}