package com.example.test.designpattern.composite.computer.leaf;

import com.example.test.designpattern.composite.computer.ComputerDevice;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Body implements ComputerDevice {

    private int price;
    private int power;

}
