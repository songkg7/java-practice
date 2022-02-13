package com.example.test.cleanarchitecture.account.domain;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "activity")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityJpaEntity {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime timestamp;

    private Long ownerAccountId;

    private Long sourceAccountId;

    private Long targetAccountId;

    private Long amount;
}
