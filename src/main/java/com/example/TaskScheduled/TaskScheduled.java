package com.example.TaskScheduled;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TaskScheduled {
	public static void main(String[] args) {
		SpringApplication.run(TaskScheduled.class, args);
	}
}
