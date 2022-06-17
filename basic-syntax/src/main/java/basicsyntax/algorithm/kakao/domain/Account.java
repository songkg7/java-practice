package basicsyntax.algorithm.kakao.domain;

import java.util.Objects;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode(of = "name")
public final class Account {
    private final String name;
    private final Report report;
    private int reported = 0;

    private Account(String name, Report report) {
        this.name = name;
        this.report = report;
    }

    public static Account create(String name, Report report) {
        return new Account(name, report);
    }

    public void report(Account account) {
        report.report(account);
    }

    boolean isExist(String name) {
        return Objects.equals(this.name, name);
    }

    long receiveMailCount() {
        return report.calculateBannedAccount();
    }

    void reported() {
        reported++;
    }

    boolean isBanned() {
        return reported >= report.getLimitCount();
    }
}
