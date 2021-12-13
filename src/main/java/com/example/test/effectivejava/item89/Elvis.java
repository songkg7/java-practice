package com.example.test.effectivejava.item89;

import java.io.Serializable;
import java.util.Arrays;

public class Elvis implements Serializable {

    public static final Elvis INSTANCE = new Elvis();

    public Elvis() {
    }

    private String[] favoriteSongs = {"Hound Dog", "Heartbreak Hotel"};

    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }

    private Object readResolve() {
        return INSTANCE;
    }

}
