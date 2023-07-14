package com.example.practice.student.command;

import com.example.practice.student.entity.Student;

public record CreateStudentCommand(
        String name,
        String email
) {
    public Student toEntity() {
        return Student.create(name, email);
    }
}
