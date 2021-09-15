package com.db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
	            .allowedOrigins(CrossOrigin.DEFAULT_ORIGINS)
	            .allowedHeaders(CrossOrigin.DEFAULT_ALLOWED_HEADERS)
	            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
	            .maxAge(3600L);
			}
			
		};
	}
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry
//				.addMapping("/api/emp/**") //kaya path ni access apvi 6
//				.allowedOrigins("http://localhost:4200") //kaya servere start ne
//				.allowedHeaders("application/json") //header type
//				.allowedMethods("GET","POST","PUT","DELETE","OPTIONS") //method
//				.maxAge(3600L); //use time seconds
//			}
//		};
//	}
}
