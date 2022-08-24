package com.example.springbatch.reader;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.batch.item.support.ListItemReader;

class SynchronizedItemReaderTest {

    @Test
    void listItemReader() throws InterruptedException {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            numbers.add(i);
        }

        int numberOfThread = 10;
        ExecutorService service = Executors.newFixedThreadPool(50);
        CountDownLatch latch = new CountDownLatch(numberOfThread);

        ListItemReader<Integer> reader = new ListItemReader<>(numbers);
        for (int i = 0; i < numberOfThread; i++) {
            service.execute(() -> {
                reader.read();
                latch.countDown();
            });
        }
        latch.await();

//        Assertions.assertThat()
    }

    @Test
    void synchronizedItemReader() {

    }
}
