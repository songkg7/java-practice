package composite;

import composite.computer.Computer;
import composite.computer.leaf.Body;
import composite.computer.leaf.KeyBoard;
import composite.computer.leaf.Monitor;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void test_1() {
        // Computer 의 부품들을 생성
        KeyBoard keyBoard = new KeyBoard(5, 2);
        Body body = new Body(100, 70);
        Monitor monitor = new Monitor(20, 30);

        // Computer 객체를 생성하고 부품 조립
        Computer computer = new Computer();
        computer.addComponent(keyBoard);
        computer.addComponent(body);
        computer.addComponent(monitor);

        // 컴퓨터의 가격과 소비 전력량
        System.out.println("computer power = " + computer.getPower() + "W");
        System.out.println("computer price = " + computer.getPrice() + "만원");

    }

}