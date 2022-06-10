package com.example.javapractice.designpattern.composite.computer;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Computer implements ComputerDevice {

    private List<ComputerDevice> components = new ArrayList<>();

    public void addComponent(ComputerDevice computerDevice) {
        components.add(computerDevice);
    }

    public void removeComponent(ComputerDevice computerDevice) {
        components.remove(computerDevice);
    }

    @Override
    public int getPrice() {
        return components.stream().mapToInt(ComputerDevice::getPrice).sum();
    }

    @Override
    public int getPower() {
        return components.stream().mapToInt(ComputerDevice::getPower).sum();
    }

}
