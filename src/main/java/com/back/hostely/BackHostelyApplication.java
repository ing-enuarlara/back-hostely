package com.back.hostely;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BackHostelyApplication {
    public static void main(String[] args) {
        SpringApplication.run(BackHostelyApplication.class, args);
    }
}