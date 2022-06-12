package com.example.javapractice.objects.chapter12;

import java.util.List;
import java.util.stream.Collectors;

public class GradeLecture extends Lecture {
    private List<Grade> grades;

    public GradeLecture(String title, int pass, List<Grade> grades, List<Integer> scores) {
        super(title, pass, scores);
        this.grades = grades;
    }

    @Override
    public String evaluate() {
        return super.evaluate() + ", " + gradesStatistics();
    }

    private String gradesStatistics() {
        return grades.stream().map(this::format).collect(Collectors.joining(" "));
    }

    private String format(Grade grade) {
        return String.format("%s:%d", grade.getName(), gradeCount(grade));
    }

    private long gradeCount(Grade grade) {
        return getScores().stream().filter(grade::include).count();
    }

    // 상속을 사용하면 새로운 기느을 쉽고 빠르게 추가할 수 있다.
    // but, 코드 재사용을 목적으로 상속을 사용해서는 안된다.
    public double average(String gradeName) {
        return grades.stream()
                .filter(grade -> grade.isName(gradeName))
                .findFirst()
                .map(this::gradeAverage)
                .orElse(0d);
    }

    private double gradeAverage(Grade grade) {
        return getScores().stream()
                .filter(grade::include)
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    /**
     * GradeLecture 에 stats 메시지를 전송하면 self 참조는 GradeLecture 의 인스턴스를 가리키도록 설정되고 메서드 탐색은 GradeLecture 클래스에서부터 시작된다.
     * self 전송은 자식 클래스에서 부모 클래스 방향으로 진행되는 동적 메서드 탐색 경로를 다시 self 참조가 가리키는 원래의 자식 클래스로 이동시킨다.
     * 이로 인해 최악의 경우에는 실제로 실행될 메서드를 이해하기 위해 상속 계층 전체를 훑어가며 코드를 이해해야 하는 상황이 발생할 수도 있다. 결과적으로
     * self 전송이 깊은 상속 계층과 계층 중간중간에 함정처럼 숨겨져 있는 메서드 오버라이딩과 만나면 극단적으로 이해하기 어려운 코드가 만들어진다. (419p)
     */
    @Override
    public String getEvaluationMethod() {
        return "Grade";
    }
}
