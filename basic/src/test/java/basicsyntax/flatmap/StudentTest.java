package basicsyntax.flatmap;

import static java.util.stream.Collectors.filtering;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

class StudentTest {
    
    @Test
    void flatMap_4() {
        Student student1 = Student.from(90, 80, 70);
        Student student2 = Student.from(89, 100, 67);
        Student student3 = Student.from(48, 70, 98);
        Student student4 = Student.from(97, 83, 89);
        List<Student> students = Arrays.asList(student1, student2, student3, student4);

        students.stream()
                .flatMapToInt(student -> IntStream.of(student.getKor(), student.getEng(), student.getMath()))
                .average()
                .ifPresent(avg -> System.out.println(Math.round(avg * 10) / 10.0));
    }

    @Test
    void groupingBy_1() {
        Student student1 = Student.from(100, 100, 100);
        Student student2 = Student.from(90, 76, 85);
        Student student3 = Student.from(80, 100, 91);

        List<Student> students1 = List.of(student1, student2, student3);
        List<Student> students2 = List.of(student1, student2, student3);
        List<Student> students3 = List.of(student1, student2, student3);

        List<List<Student>> lists = List.of(students1, students2, students3);

        Map<Integer, List<Student>> map = lists.stream()
                .flatMap(Collection::stream)
                .collect(groupingBy(
                        Student::getKor, filtering(student -> student.getEng() < 90, toList())));

        System.out.println("map = " + map);
    }
}