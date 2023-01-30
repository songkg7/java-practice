package basic.oop.sea.ship;

import basic.oop.sea.cargo.Cargo;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;

@Getter
public class ContainerShip implements Ship {

    private int durability = 100;
    private final int attackPower = 0;

    private final List<Cargo> cargoRoom = new ArrayList<>();

    @Override
    public void sailing() {
        System.out.println("ContainerShip sailing");
    }

    @Override
    public void damage(int attackPower) {
        durability -= attackPower;
    }

    public void loading(Cargo cargo) {
        cargoRoom.add(cargo);
    }
}
