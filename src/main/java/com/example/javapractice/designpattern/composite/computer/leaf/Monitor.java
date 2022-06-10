package com.example.javapractice.designpattern.composite.computer.leaf;

import com.example.javapractice.designpattern.composite.computer.ComputerDevice;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Monitor implements ComputerDevice {

    private int price;
    private int power;

}
