package com.example.javapractice.effectivejava.item05;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MosaicTest {

    @Test
    @DisplayName("의존성 주입을 사용하는 팩토리 메서드 패턴")
    void supplier() {
        MosaicFactory mosaicFactory = new MosaicFactory();
        Mosaic mosaic = mosaicFactory.create(Tile::new);
    }
}