package com.example.springbatch.reader;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.batch.item.support.ListItemReader;

class SynchronizedItemReaderTest {

    private List<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            numbers.add(i);
        }
    }

    @Test
    @DisplayName("ListItemReader 는 multi-thread 동작시 NPE 가 발생하여 제대로된 read 처리를 할 수 없다.")
    void listItemReader() throws InterruptedException {
        int numberOfThread = 10;
        ExecutorService service = Executors.newFixedThreadPool(50);
        CountDownLatch latch = new CountDownLatch(numberOfThread);

        ListItemReader<Integer> reader = new ListItemReader<>(numbers);
        AtomicInteger errorCount = new AtomicInteger();

        for (int i = 0; i < numberOfThread; i++) {
            service.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    try {
                        reader.read();
                    } catch (NullPointerException e) {
                        errorCount.addAndGet(1);
                    }
                }
                latch.countDown();
            });
        }
        latch.await();

        assertThat(errorCount).hasPositiveValue();
    }

    @Test
    @DisplayName("SynchronizedItemReader 는 thread-safe 하게 동작한다.")
    void synchronizedItemReader() throws InterruptedException {
        SynchronizedItemReader<Integer> reader = new SynchronizedItemReader<>(numbers);

        int numberOfThread = 10;
        ExecutorService service = Executors.newFixedThreadPool(50);
        CountDownLatch latch = new CountDownLatch(numberOfThread);

        AtomicInteger readCount = new AtomicInteger();
        for (int i = 0; i < numberOfThread; i++) {
            service.execute(() -> {
                for (int j = 0; j < 1000; j++) {
                    reader.read();
                    readCount.addAndGet(1);
                }
                latch.countDown();
            });
        }
        latch.await();

        assertThat(readCount).hasValue(numbers.size());
    }
}
