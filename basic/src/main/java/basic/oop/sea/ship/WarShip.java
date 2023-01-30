package basic.oop.sea.ship;

public class WarShip implements Ship {

    private int durability = 100;
    private final int attackPower = 30;

    @Override
    public void sailing() {
        System.out.println("WarShip sailing");
    }

    @Override
    public void damage(int attackPower) {
        durability -= attackPower;
    }

    public void attack(Ship ship) {
        // 선박은 자신의 내구도를 스스로 감소시킨다.
        ship.damage(attackPower);
    }
}
