package com.example.test.effectivejava.item78;

import java.util.concurrent.TimeUnit;

public class StopThreadV2 {

    // volatile 을 사용할 때엔 주의가 필요하다
    private static volatile boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {
        Thread backgroundThread = new Thread(() -> {
            int i = 0;
            while (!stopRequested) {
                i++;
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);
        stopRequested = true;
    }

}
