package com.example.yang;

import com.example.yang.job.AutoOrderd;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.io.IOException;

@SpringBootApplication
@EnableScheduling
public class LearnSpringBootApplication {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(LearnSpringBootApplication.class, args);
    }
}
