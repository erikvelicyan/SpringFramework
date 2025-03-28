package com.example.skillboxthirdtask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.example.skillboxthirdtask.repository")
@EntityScan(basePackages = "com.example.skillboxthirdtask.contact")
public class SkillboxThirdTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(SkillboxThirdTaskApplication.class, args);
    }
}
