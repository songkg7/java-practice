package com.example.test.designpattern.composite.leaf;

import com.example.test.designpattern.composite.ComputerDevice;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class KeyBoard implements ComputerDevice {

    private int price;
    private int power;

}
