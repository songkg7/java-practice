package com.example.test.effectivejava.item05;

import java.util.List;

public class Mosaic {

    private List<Tile> tiles;

    public Mosaic(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public static Mosaic of(Tile... tile) {
        return new Mosaic(List.of(tile));
    }

}
