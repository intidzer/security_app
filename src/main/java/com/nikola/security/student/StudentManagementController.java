package com.nikola.security.student;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(path = "/management/api/v1/students")
public class StudentManagementController {

    private static final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "anna"),
            new Student(2, "josh"),
            new Student(3, "Motambe"));

    @GetMapping
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public List<Student> getAllStudents() {
        return STUDENTS;
    }

    @DeleteMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteStudent(@PathVariable(name = "studentId") Integer studentId) {
//        STUDENTS.remove(STUDENTS
//                .stream()
//                .filter(student -> student.getStudentId().equals(studentId))
//                .findFirst()
//                .orElseThrow(() -> new IllegalStateException("No student found")));
        System.out.println("Student with ID " + studentId + " is removed");
    }

    @PostMapping
    @PreAuthorize("hasAuthority('student:write')")
    public void registerNewStudent(@RequestBody Student student) {
        System.out.println(student);
//        STUDENTS.add(student);
    }

    @PutMapping(path = "{studentId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void updateStudent(@PathVariable Integer studentId, @RequestBody Student student) {
        System.out.println(String.format("%s %s", studentId, student));
    }

}
