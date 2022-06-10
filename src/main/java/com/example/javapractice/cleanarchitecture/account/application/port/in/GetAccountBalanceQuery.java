package com.example.javapractice.cleanarchitecture.account.application.port.in;

import com.example.javapractice.cleanarchitecture.account.domain.Account.AccountId;
import com.example.javapractice.cleanarchitecture.account.domain.Money;

public interface GetAccountBalanceQuery {
    Money getAccountBalance(AccountId accountId);
}
