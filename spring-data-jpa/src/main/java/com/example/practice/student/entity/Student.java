package com.example.practice.student.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Student {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String email;

    public Student(String name, String email) {
        this.id = null;
        this.name = name;
        this.email = email;
    }

    public static Student create(String name, String email) {
        return new Student(name, email);
    }

}
