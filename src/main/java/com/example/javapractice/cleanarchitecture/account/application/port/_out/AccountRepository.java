package com.example.javapractice.cleanarchitecture.account.application.port._out;

import com.example.javapractice.cleanarchitecture.account.domain.AccountJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<AccountJpaEntity, Long> {
}
