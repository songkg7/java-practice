package com.example.test.designpattern.command.command;

import com.example.test.designpattern.command.functions.Lamp;
import lombok.Getter;

@Getter
public class LampOnCommand implements Command {

    private Lamp lamp;

    public LampOnCommand(Lamp lamp) {
        this.lamp = lamp;
    }

    @Override
    public void execute() {
        lamp.turnOn();
    }

}
