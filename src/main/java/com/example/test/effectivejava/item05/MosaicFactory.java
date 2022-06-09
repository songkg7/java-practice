package com.example.test.effectivejava.item05;

import java.util.function.Supplier;

public class MosaicFactory {

    public <T extends Tile> Mosaic create(Supplier<T> tileFactory) {
        return Mosaic.of(tileFactory.get());
    }

}
