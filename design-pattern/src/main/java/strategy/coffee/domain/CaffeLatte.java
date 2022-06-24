package strategy.coffee.domain;

import strategy.coffee.Coffee;

public class CaffeLatte implements Coffee {

    @Override
    public void brew() {
        System.out.println("CaffeLatte");
    }

}
