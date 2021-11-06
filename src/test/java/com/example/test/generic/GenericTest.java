package com.example.test.generic;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;

class GenericTest {

    @Test
    void test_1() {
        Generic<BClazz> generic = new Generic<>();

        BClazz type = new BClazz();
        type.setDate(LocalDateTime.now());
        generic.setType(type);
        BClazz type1 = generic.getType();
        System.out.println("type1.getDate() = " + type1.getDate());

    }

}