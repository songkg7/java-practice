package command.domain;

import command.command.Command;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Button {

    private Command command;

    public Button(Command command) {
        this.command = command;
    }

    public void pressed() {
        command.execute();
    }

}
