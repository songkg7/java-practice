package com.example.test.cleanarchitecture.account.application.port._out;

import com.example.test.cleanarchitecture.account.domain.Account;
import com.example.test.cleanarchitecture.account.domain.Account.AccountId;
import java.time.LocalDateTime;

public interface LoadAccountPort {

    Account loadAccount(AccountId accountId, LocalDateTime now);
}
