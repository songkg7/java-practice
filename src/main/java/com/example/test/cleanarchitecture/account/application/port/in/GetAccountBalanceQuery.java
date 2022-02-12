package com.example.test.cleanarchitecture.account.application.port.in;

import com.example.test.cleanarchitecture.account.domain.Account.AccountId;
import com.example.test.cleanarchitecture.account.domain.Money;

public interface GetAccountBalanceQuery {
    Money getAccountBalance(AccountId accountId);
}
