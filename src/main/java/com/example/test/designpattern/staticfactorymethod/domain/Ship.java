package com.example.test.designpattern.staticfactorymethod.domain;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PROTECTED)
public class Ship {

    @Id
    @GeneratedValue
    private UUID id;

    private String name;

    private String type;

    public static Ship create() {
        return new Ship();
    }

    public Ship duplicate() {
        return new Ship(id, name, type);
    }

    public Ship withType(String type) {
        Ship ship = duplicate();
        ship.type = type;
        return ship;
    }

}
