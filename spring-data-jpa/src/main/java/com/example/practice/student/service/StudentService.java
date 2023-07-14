package com.example.practice.student.service;

import com.example.practice.student.command.CreateStudentCommand;
import com.example.practice.student.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    @Transactional
    public void createStudent(CreateStudentCommand command) {
        var student = command.toEntity();
        studentRepository.save(student);
    }

}
