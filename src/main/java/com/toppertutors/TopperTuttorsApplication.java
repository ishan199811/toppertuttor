package com.toppertutors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@SpringBootApplication
@EnableAutoConfiguration

public class TopperTuttorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TopperTuttorsApplication.class, args);
	}
}

