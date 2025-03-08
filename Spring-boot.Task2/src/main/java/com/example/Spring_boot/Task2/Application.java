package com.example.Spring_boot.Task2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling    //task2
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
