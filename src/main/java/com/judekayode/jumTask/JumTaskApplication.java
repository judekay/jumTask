package com.judekayode.jumTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class JumTaskApplication {
    public static void main(String[] args) {
        SpringApplication.run(JumTaskApplication.class, args);
    }
}
