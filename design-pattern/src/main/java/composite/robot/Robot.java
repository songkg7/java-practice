package composite.robot;

import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Robot implements RobotDevice {

    private int power;
    private List<RobotDevice> components = new ArrayList<>();

    public void addComponent(RobotDevice robotDevice) {
        components.add(robotDevice);
    }

    public void removeComponent(RobotDevice robotDevice) {
        components.remove(robotDevice);
    }

    @Override
    public int getPower() {
        return components.stream().mapToInt(RobotDevice::getPower).sum();
    }

}
