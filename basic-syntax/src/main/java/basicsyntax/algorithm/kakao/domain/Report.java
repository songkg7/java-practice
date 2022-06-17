package basicsyntax.algorithm.kakao.domain;

import java.util.HashSet;
import java.util.Set;

public final class Report {
    private final Set<Account> accountReport = new HashSet<>();
    private final int limitCount;

    private Report(int limitCount) {
        this.limitCount = limitCount;
    }

    public static Report of(int limitCount) {
        return new Report(limitCount);
    }

    void report(Account account) {
        if (accountReport.add(account)) {
            account.reported();
        }
    }

    long calculateBannedAccount() {
        return accountReport.stream()
                .filter(Account::isBanned)
                .count();
    }

    public int getLimitCount() {
        return limitCount;
    }
}
