package com.example.skillboxsecondtask.commands;

import com.example.skillboxsecondtask.service.StudentService;
import com.example.skillboxsecondtask.student.Student;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

import java.util.List;

@ShellComponent
public class StudentCommands {

    private final StudentService studentService;

    public StudentCommands(StudentService studentService) {
        this.studentService = studentService;
    }

    @ShellMethod("List all students")
    public String listStudents() {
        List<Student> students = studentService.getAllStudents();
        return students.isEmpty() ? "No students found." : students.toString();
    }

    @ShellMethod("Add a student")
    public String addStudent(String firstName, String lastName, int age) {
        Student student = studentService.addStudent(firstName, lastName, age);
        return "Added: " + student;
    }

    @ShellMethod("Remove a student by ID")
    public String removeStudent(Long id) {
        return studentService.removeStudent(id) ? "Student removed." : "Student not found.";
    }

    @ShellMethod("Clear all students")
    public String clearStudents() {
        studentService.clearStudents();
        return "All students removed.";
    }
}

