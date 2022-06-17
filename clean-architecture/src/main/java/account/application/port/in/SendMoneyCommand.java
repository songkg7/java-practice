package account.application.port.in;

import account.domain.Account;
import account.domain.Account.AccountId;
import account.domain.Money;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class SendMoneyCommand extends SelfValidating<SendMoneyCommand> {

    @NotNull
    private final Account.AccountId sourceAccountId;

    @NotNull
    private final Account.AccountId targetAccountId;

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
