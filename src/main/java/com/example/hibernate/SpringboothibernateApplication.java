package com.example.hibernate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@EnableAspectJAutoProxy
@OpenAPIDefinition(info=@Info(description = "This is a book class",version = "1.0",
					title = "Spring API"))
public class SpringboothibernateApplication {
//hai
	//
	///
	public static void main(String[] args) {
		SpringApplication.run(SpringboothibernateApplication.class, args);
	}
//end
}