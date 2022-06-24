package strategy.coffee.domain;

import strategy.coffee.Coffee;

public class Americano implements Coffee {

    @Override
    public void brew() {
        System.out.println("Americano");
    }

}
