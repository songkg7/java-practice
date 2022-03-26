package com.example.test.gettersetter;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private Teacher teacher;
    private List<Student> students = new ArrayList<>();

    public void startHomeRoom() {
        students.forEach(Student::attendance);
    }
}
