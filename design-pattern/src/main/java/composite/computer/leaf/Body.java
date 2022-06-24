package composite.computer.leaf;

import composite.computer.ComputerDevice;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Body implements ComputerDevice {

    private int price;
    private int power;

}
