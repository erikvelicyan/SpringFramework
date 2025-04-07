package com.example.skillboxsecondtask.service;

import com.example.skillboxsecondtask.createdevent.StudentCreatedEvent;
import com.example.skillboxsecondtask.createdevent.StudentDeletedEvent;
import com.example.skillboxsecondtask.student.Student;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class StudentService {
 private final Map<Long, Student> students = new HashMap<>();
 private final AtomicLong idGenerator = new AtomicLong(1);
 private final ApplicationEventPublisher eventPublisher;

public StudentService (ApplicationEventPublisher eventPublisher){
    this.eventPublisher = eventPublisher;
};

public List<Student> getAllStudents(){
    return new ArrayList<>(students.values());
}

public Student addStudent(String firstName, String lastName, Integer age ){
    Student student = new Student(idGenerator.getAndIncrement(),firstName,lastName,age);
    students.put(student.getId(), student);
    eventPublisher.publishEvent(new StudentCreatedEvent(student));
    return student;
}


    public boolean removeStudent(Long id) {
        if (students.remove(id) != null) {
            eventPublisher.publishEvent(new StudentDeletedEvent(id));
            return true;
        }
        return false;
    }

    public void clearStudents() {
        students.clear();
    }
};


