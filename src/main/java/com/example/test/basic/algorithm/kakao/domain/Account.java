package com.example.test.basic.algorithm.kakao.domain;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode(of = "name")
public class Account {
    private final String name;
    private final Set<Account> accountReport = new HashSet<>();
    private final int limitCount;
    private int reported = 0;

    private Account(String name, int limitCount) {
        this.name = name;
        this.limitCount = limitCount;
    }

    public static Account create(String name, int limitCount) {
        return new Account(name, limitCount);
    }

    public void report(Account account) {
        if (accountReport.add(account)) {
            account.reported++;
        }
    }

    boolean isExist(String name) {
        return Objects.equals(this.name, name);
    }

    long receiveMailCount() {
        return accountReport.stream()
                .filter(Account::isBanned)
                .count();
    }

    boolean isBanned() {
        return reported >= limitCount;
    }
}
