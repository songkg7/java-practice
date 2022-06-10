package com.example.javapractice.designpattern.adapter;

import org.junit.jupiter.api.Test;

class AdapterTest {

    @Test
    void adapter() {
        Nintendo nintendo = new Nintendo();
        Samsung samsung = new Samsung();

        SamsungAdapter samsungAdapter = new SamsungAdapter(samsung);

        samsungAdapter.v110();
        samsung.v220();
        nintendo.v110();
    }
}