package com.example.skillboxsecondtask.createdevent;

public class StudentDeletedEvent {
    private final Long studentId;

    public StudentDeletedEvent(Long studentId) {
        this.studentId = studentId;
    }

    public Long getStudentId() {
        return studentId;
    }
}