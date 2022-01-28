package com.ats.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan("com.ats")
@EntityScan("com.ats.model")
@EnableJpaRepositories("com.ats.repository")
@SpringBootApplication
public class ApplicationTrackingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationTrackingSystemApplication.class, args);
	}
	
}
