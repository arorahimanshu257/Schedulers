package com.example.Schedulers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class SchedulersApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchedulersApplication.class, args);
    }

}
