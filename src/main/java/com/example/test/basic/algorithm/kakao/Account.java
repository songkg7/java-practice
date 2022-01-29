package com.example.test.basic.algorithm.kakao;

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

    private int reported = 0;

    private Account(String name) {
        this.name = name;
    }

    public static Account create(String name) {
        return new Account(name);
    }

    void report(Account account) {
        if (accountReport.add(account)) {
            account.reported++;
        }
    }

    boolean isExist(String name) {
        return Objects.equals(this.name, name);
    }

    boolean isBanned(int limitCount) {
        return reported >= limitCount;
    }

    long receiveMailCount(int limitCount) {
        return accountReport.stream()
                .filter(account -> account.isBanned(limitCount))
                .count();
    }
}
