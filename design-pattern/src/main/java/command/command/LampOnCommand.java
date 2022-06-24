package command.command;

import command.functions.Lamp;
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
