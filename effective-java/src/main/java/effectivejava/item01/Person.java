package effectivejava.item01;

// 생성자 대신 정적 팩토리 메서드 패턴을 사용하라.
public class Person {

    private String name;
    private int age;

    // 단점 1. 기본 생성자가 private 으로 막혀있으므로 상속이 불가능하다.
    private Person() {
    }

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // 장점. 생성자에 역할에 맞는 이름을 부여할 수 있게 된다.
    public static Person of(String name, int age) {
        return new Person(name, age);
    }
}
