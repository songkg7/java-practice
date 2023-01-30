package basic.oop.sea.ship;

import basic.oop.sea.cargo.Cargo;
import java.util.ArrayList;
import java.util.List;

public class ContainerShip implements Ship {

    private final List<Cargo> cargoRoom = new ArrayList<>();

    @Override
    public void sailing() {
        System.out.println("ContainerShip sailing");
    }

    public void loading(Cargo cargo) {
        cargoRoom.add(cargo);
    }
}
