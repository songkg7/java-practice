package basicsyntax.multithread;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Test;

class MyCounterTest {

    @Test
    void testCounter() throws InterruptedException {
        MyCounter counter = new MyCounter();
        for (int i = 0; i < 500; i++) {
            counter.increment();
        }
        assertThat(counter.getCount()).isEqualTo(500);
    }

    @Test
    void testCounterWithConcurrency() throws InterruptedException {
        int numberOfThread = 2;
        ExecutorService service = Executors.newFixedThreadPool(10);
        CountDownLatch latch = new CountDownLatch(numberOfThread);
        MyCounter counter = new MyCounter();
        for (int i = 0; i < numberOfThread; i++) {
            service.execute(() -> {
                try {
                    counter.increment();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                latch.countDown();
            });
        }
        latch.await();
        assertThat(counter.getCount()).isEqualTo(numberOfThread);
    }
}
