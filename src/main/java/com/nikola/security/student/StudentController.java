package com.nikola.security.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/students")
public class StudentController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "anna"),
            new Student(2, "josh"),
            new Student(3, "Motambe"));

    @GetMapping(path = "{studentId}")
    public Student getStudent(@PathVariable(name = "studentId") Integer studentId) {
        return STUDENTS
                .stream()
                .filter(student -> student.getStudentId().equals(studentId))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException("Student with ID: " + studentId + " was not found"));
    }

}
