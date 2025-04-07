package com.example.skillboxsecondtask.initializer;
import org.springframework.beans.factory.annotation.Value;


import com.example.skillboxsecondtask.service.StudentService;
import jakarta.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class StudentInitializer {

    @Value("${student.load-on-startup:false}")
    private boolean loadOnStartup;

    private final StudentService studentService;

    public StudentInitializer(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostConstruct
    public void init() {
        if (loadOnStartup) {
            studentService.addStudent("Иван", "Иванов", 20);
            studentService.addStudent("Анна", "Петрова", 22);
            System.out.println("[INFO] Студенты загружены при старте приложения.");
        }
    }
}
