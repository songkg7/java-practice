package com.example.springbatch.reader;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import org.springframework.batch.item.ItemReader;
import org.springframework.lang.Nullable;

public class SynchronizedItemReader<T> implements ItemReader<T> {
    private final Queue<T> queue;

    public SynchronizedItemReader(List<T> collection) {
        this.queue = new ConcurrentLinkedDeque<>(collection);
    }

    @Nullable
    @Override
    public T read() {
        return queue.poll();
    }

}
