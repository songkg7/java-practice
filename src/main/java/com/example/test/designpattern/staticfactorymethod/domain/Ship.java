package com.example.test.designpattern.staticfactorymethod.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Ship {

    @Id
    @GeneratedValue
    private Long id;

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
