package com.example.test.designpattern.staticfactorymethod.controller;

import com.example.test.designpattern.staticfactorymethod.domain.Ship;
import com.example.test.designpattern.staticfactorymethod.service.ShipService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/ship")
@RequiredArgsConstructor
public class ShipController {

    private final ShipService shipService;

    @GetMapping
    public List<Ship> select() {
        return shipService.selectAll();
    }

    @PostMapping("/create")
    public UUID create() {
        Ship ship = shipService.buildingShip();
        return ship.getId();
    }

}
