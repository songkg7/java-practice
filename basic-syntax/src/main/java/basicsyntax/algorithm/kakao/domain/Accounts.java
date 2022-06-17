package basicsyntax.algorithm.kakao.domain;

import java.util.List;

public final class Accounts {
    private final List<Account> accounts;

    private Accounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public static Accounts of(List<Account> accounts) {
        return new Accounts(accounts);
    }

    public Account getAccountByName(String name) {
        return accounts.stream()
                .filter(account -> account.isExist(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("account not exist."));
    }

    public int[] resultByBanLimit() {
        return accounts.stream()
                .mapToInt(account -> (int) account.receiveMailCount())
                .toArray();
    }
}
