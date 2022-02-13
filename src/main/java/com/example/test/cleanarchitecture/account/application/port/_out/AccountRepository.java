package com.example.test.cleanarchitecture.account.application.port._out;

import com.example.test.cleanarchitecture.account.domain.AccountJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountJpaEntity, Long> {
}
