package com.example.javapractice.designpattern.composite.robot.leaf;

import com.example.javapractice.designpattern.composite.robot.RobotDevice;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Arm implements RobotDevice {

    private int power;

}
