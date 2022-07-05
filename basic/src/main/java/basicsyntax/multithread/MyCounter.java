package basicsyntax.multithread;

import lombok.Getter;

@Getter
public class MyCounter {
    private int count;

    public synchronized void increment() throws InterruptedException {
        int temp = count;
        wait(100);
        count = temp + 1;
    }
}
