package com.cognizant.AuditChecklistServices;

import java.util.List;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.cognizant.AuditChecklistServices.Entity.Question;
import com.cognizant.AuditChecklistServices.Repository.AuditRepository;

/**
 * This class has mappings as- PostConstruct-addingQuestions()
 */

@SpringBootApplication
@EnableFeignClients
public class AuditChecklistServicesApplication {
	/**
	 * main Method- SpringBoot main method to launch an application.
	 */

	@Autowired
	AuditRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(AuditChecklistServicesApplication.class, args);
	}

	@PostConstruct
	public void addingQuestions() {
		List<Question> list = Stream.of(
				new Question(1, "Internal", "Have all Change requests followed SDLC before PROD move?", "NO"),
				new Question(2, "Internal", "Have all Change requests been approved by the application owner? ", "NO"),
				new Question(3, "Internal", "Are all artifacts like CR document, Unit test cases available?", "NO"),
				new Question(4, "Internal", "Is the SIT and UAT sign-off available?", "NO"),
				new Question(5, "Internal", "Is data deletion from the system done with application owner approval?",
						"NO"),
				new Question(6, "SOX", "Have all Change requests followed SDLC before PROD move?", "NO"),
				new Question(7, "SOX", "Have all Change requests been approved by the application owner?", "NO"),
				new Question(8, "SOX",
						"For a major change, was there a database backup taken before and after PROD move?", "NO"),
				new Question(9, "SOX", "Has the application owner approval obtained while adding a user to the system?",
						"NO"),
				new Question(10, "SOX", "Is data deletion from the system done with application owner approval?", "NO"))
				.collect(Collectors.toList());

		repo.saveAll(list);

	}

}
