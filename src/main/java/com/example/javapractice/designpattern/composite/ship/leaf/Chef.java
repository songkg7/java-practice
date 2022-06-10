package com.example.javapractice.designpattern.composite.ship.leaf;

import com.example.javapractice.designpattern.composite.ship.Crew;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Chef implements Crew {

    private String name;
    private int age;

}
