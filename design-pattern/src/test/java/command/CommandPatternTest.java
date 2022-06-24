package command;

import command.command.AlarmOnCommand;
import command.command.LampOnCommand;
import command.domain.Button;
import command.functions.Alarm;
import command.functions.Lamp;
import org.junit.jupiter.api.Test;

class CommandPatternTest {

    @Test
    void test_1() {
//        Lamp lamp = new Lamp();
//        Button lampButton = new Button(lamp);
//        lampButton.pressed();

        Lamp lamp = new Lamp();
        LampOnCommand lampOnCommand = new LampOnCommand(lamp);

        Alarm alarm = new Alarm();
        AlarmOnCommand alarmOnCommand = new AlarmOnCommand(alarm);

        Button lampButton = new Button(lampOnCommand);
        Button alarmButton = new Button(alarmOnCommand);

        lampButton.pressed();
        alarmButton.pressed();

        alarmButton.setCommand(lampOnCommand);
        alarmButton.pressed();
    }

}