package com.example.test.designpattern.command.command;

import com.example.test.designpattern.command.functions.Alarm;

public class AlarmOnCommand implements Command {

    private Alarm alarm;

    public AlarmOnCommand(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void execute() {
        alarm.start();
    }

}
