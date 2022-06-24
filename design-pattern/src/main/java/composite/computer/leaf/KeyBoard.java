package composite.computer.leaf;

import composite.computer.ComputerDevice;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class KeyBoard implements ComputerDevice {

    private int price;
    private int power;

}
