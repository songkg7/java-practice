package com.example.javapractice.designpattern.staticfactorymethod.service;

import com.example.javapractice.designpattern.staticfactorymethod.domain.Ship;
import com.example.javapractice.designpattern.staticfactorymethod.repository.ShipRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ShipService {

    private final ShipRepository shipRepository;

    public Ship buildingShip() {
        Ship ship = Ship.create();
        log.info("ship.getId() = {}", ship.getId());
        shipRepository.save(ship);
        return ship;
    }

    @Transactional(readOnly = true)
    public List<Ship> selectAll() {
        return shipRepository.findAll();
    }

}
