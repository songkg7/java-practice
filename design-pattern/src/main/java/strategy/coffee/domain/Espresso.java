package strategy.coffee.domain;

import strategy.coffee.Coffee;

public class Espresso implements Coffee {

    @Override
    public void brew() {
        System.out.println("Espresso");
    }

}
