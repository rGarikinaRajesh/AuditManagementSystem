package com.cognizant.AuditBenchmarksServices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AuditBenchmarksServicesApplication {

	public static void main(String[] args) {
		/**
		 * main Method- Spring Boot's method to launch an application.
		 */
		SpringApplication.run(AuditBenchmarksServicesApplication.class, args);
	}

}
