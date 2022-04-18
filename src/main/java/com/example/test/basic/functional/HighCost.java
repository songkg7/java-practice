package com.example.test.basic.functional;

import java.util.concurrent.TimeUnit;

public class HighCost {

    public static void printIfValidIndex(int index, String value) {
        if (index >= 0) {
            System.out.println("the value is " + value);
        } else {
            System.out.println("Invalid");
        }
    }

    public static String highCostValue() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Song";
    }

}
