package com.example.test.designpattern.composite.robot.leaf;

import com.example.test.designpattern.composite.robot.RobotDevice;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Body implements RobotDevice {

    private int power;

}
