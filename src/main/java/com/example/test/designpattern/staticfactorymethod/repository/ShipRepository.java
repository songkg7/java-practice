package com.example.test.designpattern.staticfactorymethod.repository;

import com.example.test.designpattern.staticfactorymethod.domain.Ship;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
public interface ShipRepository extends JpaRepository<Ship, UUID> {

}