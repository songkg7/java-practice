package com.example.javapractice.designpattern.command.command;

import com.example.javapractice.designpattern.command.functions.Lamp;
import lombok.Getter;

@Getter
public class LampOnCommand implements Command {

    private final Lamp lamp;

    public LampOnCommand(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        lamp.turnOn();
    }

}