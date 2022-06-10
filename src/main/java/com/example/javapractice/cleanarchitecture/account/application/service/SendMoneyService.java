package com.example.javapractice.cleanarchitecture.account.application.service;

import com.example.javapractice.cleanarchitecture.account.application.port._out.LoadAccountPort;
import com.example.javapractice.cleanarchitecture.account.application.port._out.UpdateAccountStatePort;
import com.example.javapractice.cleanarchitecture.account.application.port.in.AccountLock;
import com.example.javapractice.cleanarchitecture.account.application.port.in.SendMoneyCommand;
import com.example.javapractice.cleanarchitecture.account.application.port.in.SendMoneyUseCase;
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
