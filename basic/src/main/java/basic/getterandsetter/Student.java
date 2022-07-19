package basic.getterandsetter;

public class Student {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String introduce() {
        return String.format("제 이름은 %s 이고 나이는 %d 입니다.", name, age);
    }
}
