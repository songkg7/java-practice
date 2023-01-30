package basic.oop.sea.ship;

import lombok.Getter;

@Getter
public class WarShip extends Ship {

    private final int attackPower;

    public WarShip() {
        this.attackPower = 30;
    }

    public WarShip(int attackPower) {
        this.attackPower = attackPower;
    }

    public void attack(Ship ship) {
        if (ship == this) {
            throw new IllegalArgumentException("자기 자신을 공격할 수 없습니다.");
        }
        // 선박은 자신의 내구도를 스스로 감소시킨다.
        ship.damage(attackPower);
    }
}
