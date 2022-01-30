package com.example.test.basic.algorithm.kakao.domain;

import java.util.HashSet;
import java.util.Set;

public final class Report {
    private final Set<Account> accountReport = new HashSet<>();
    private final int limitCount;
    private int reported = 0;

    private Report(int limitCount) {
        this.limitCount = limitCount;
    }

    public static Report of(int limitCount) {
        return new Report(limitCount);
    }

    void report(Account account) {
        if (accountReport.add(account)) {
            account.getReport().reported++;
        }
    }

    long calculateBannedAccount() {
        return accountReport.stream()
                .filter(account -> account.getReport().isBanned())
                .count();
    }

    boolean isBanned() {
        return reported >= limitCount;
    }
}
