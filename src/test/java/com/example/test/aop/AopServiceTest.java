package com.example.test.aop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AopServiceTest {

    @Autowired
    AopService aopService;

    @Test
    void print() {
        aopService.print();
    }
}