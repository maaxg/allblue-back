package com.example.back.ecommerce;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class EcommerceApplication {
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(EcommerceApplication.class);
		app.setDefaultProperties(Collections
				.singletonMap("server.port", "8085"));
		app.run(args);
	}
}
