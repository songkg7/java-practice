package composite.robot.leaf;

import composite.robot.RobotDevice;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Arm implements RobotDevice {

    private int power;

}
