package com.training.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@ComponentScan({"com.training.controller", "com.training.service"})
@EntityScan("com.training.entity")
@EnableJpaRepositories("com.training.repository")
@ComponentScan(basePackages = "com.training")
public class GetStartedWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(GetStartedWithSpringBootApplication.class, args);
	}

}
