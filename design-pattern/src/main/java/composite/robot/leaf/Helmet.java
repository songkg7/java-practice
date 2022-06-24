package composite.robot.leaf;

import composite.robot.RobotDevice;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Helmet implements RobotDevice {

    private int power;

}
