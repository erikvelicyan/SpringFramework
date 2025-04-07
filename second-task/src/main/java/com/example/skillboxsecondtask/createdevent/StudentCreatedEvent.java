package com.example.skillboxsecondtask.createdevent;


import com.example.skillboxsecondtask.student.Student;

public class StudentCreatedEvent {
    private final Student student;

    public StudentCreatedEvent(Student student) {
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }
}