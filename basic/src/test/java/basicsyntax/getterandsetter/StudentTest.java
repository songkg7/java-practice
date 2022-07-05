package basicsyntax.getterandsetter;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StudentTest {

    @Test
    void student() {
        Student student = new Student("John", 20);
        String introduce = student.introduce();

//        assertThat(student.getName()).isEqualTo("John");
//        assertThat(student.getAge()).isEqualTo(20);
        assertThat(introduce).isEqualTo("제 이름은 John 이고 나이는 20 입니다.");
    }
}