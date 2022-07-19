package basic.stream.dicegame;

import lombok.Value;

@Value(staticConstructor = "ready")
public class Game {

    // TODO: first collection 사용 고려하기
    Dice firstDice;
    Dice secondDice;

    public Game play() {
        return new Game(firstDice.casting(), secondDice.casting());
    }

    public void printResult() {
        System.out.println("첫번째 주사위의 값 : " + firstDice.getPoint());
        System.out.println("두번째 주사위의 값 : " + secondDice.getPoint());

        System.out.println("합계 : " + sum());
    }

    private int sum() {
        return firstDice.getPoint().getValue() + secondDice.getPoint().getValue();
    }

}
