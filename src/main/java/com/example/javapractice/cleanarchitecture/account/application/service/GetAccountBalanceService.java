package com.example.javapractice.cleanarchitecture.account.application.service;

import com.example.javapractice.cleanarchitecture.account.application.port._out.LoadAccountPort;
import com.example.javapractice.cleanarchitecture.account.application.port.in.GetAccountBalanceQuery;
import com.example.javapractice.cleanarchitecture.account.domain.Account.AccountId;
import com.example.javapractice.cleanarchitecture.account.domain.Money;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class GetAccountBalanceService implements GetAccountBalanceQuery {

    private final LoadAccountPort loadAccountPort;

    @Override
    public Money getAccountBalance(AccountId accountId) {
        return loadAccountPort.loadAccount(accountId, LocalDateTime.now()).calculateBalance();
    }
}
