package strategy.car.behavior;

public class LeftBehavior implements CarMoveBehavior {

    @Override
    public void action() {
        System.out.println("Left");
    }

}
