package com.example.javapractice.cleanarchitecture.account.application.port.in;

import com.example.javapractice.cleanarchitecture.account.domain.Account.AccountId;
import com.example.javapractice.cleanarchitecture.account.domain.Money;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class SendMoneyCommand extends SelfValidating<SendMoneyCommand> {

    @NotNull
    private final AccountId sourceAccountId;

    @NotNull
    private final AccountId targetAccountId;

    @NotNull
    private final Money money;

    public SendMoneyCommand(AccountId sourceAccountId, AccountId targetAccountId, Money money) {
        this.sourceAccountId = sourceAccountId;
        this.targetAccountId = targetAccountId;
        this.money = money;
        requireGreaterThan(money);
        this.validateSelf();
    }

    private void requireGreaterThan(Money money) {
        if (!money.isPositive()) {
            throw new IllegalArgumentException("Must be a value greater than 0.");
        }
    }
}
