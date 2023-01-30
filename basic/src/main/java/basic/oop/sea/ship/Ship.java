package basic.oop.sea.ship;

import lombok.Getter;

@Getter
public abstract class Ship {

    private int durability = 100;

    public void sailing() {
        if (durability <= 30) {
            throw new IllegalStateException("내구도가 30 이하입니다. 항해를 지속할 수 없습니다.");
        }
        System.out.println("Ship sailing");
    }

    // TODO: immutable
    public void damage(int attackPower) {
        if (durability - attackPower < 0) {
            durability = 0;
            return;
        }
        durability -= attackPower;
    }

}
