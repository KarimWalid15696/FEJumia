package com.PhoneNumbers.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class PhoneNumbersApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(PhoneNumbersApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Server Started");
		// TODO Auto-generated method stub

	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**").allowedOrigins("http://localhost:4200");
				System.out.println("================================================");
			}
		};
	}

}
