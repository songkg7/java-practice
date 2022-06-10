package com.example.javapractice.designpattern.command.command;

import com.example.javapractice.designpattern.command.functions.Alarm;

public class AlarmOnCommand implements Command {

    private final Alarm alarm;

    public AlarmOnCommand(Alarm alarm) {
        this.alarm = alarm;
    }

    @Override
    public void execute() {
        alarm.start();
    }

}
