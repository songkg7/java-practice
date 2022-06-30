package com.example.objects.chapter10.domain;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

public class Call {
    private DateTimeInterval interval;

    public Call(LocalDateTime from, LocalDateTime to) {
        this.interval = DateTimeInterval.of(from, to);
    }

    public List<DateTimeInterval> splitByDay() {
        return interval.splitByDay();
    }

    public Duration getDuration() {
        return interval.duration();
    }

    public DateTimeInterval getInterval() {
        return interval;
    }

    public LocalDateTime getFrom() {
        return interval.getFrom();
    }

    public LocalDateTime getTo() {
        return interval.getTo();
    }
}
