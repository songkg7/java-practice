package account.application.service;

import account.application.port._out.LoadAccountPort;
import account.application.port._out.UpdateAccountStatePort;
import account.application.port.in.AccountLock;
import account.application.port.in.SendMoneyCommand;
import account.application.port.in.SendMoneyUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@RequiredArgsConstructor
public class SendMoneyService implements SendMoneyUseCase {

    private final LoadAccountPort loadAccountPort;
    private final AccountLock accountLock;
    private final UpdateAccountStatePort updateAccountStatePort;

    @Override
    public boolean sendMoney(SendMoneyCommand command) {
        return false;
    }
}
