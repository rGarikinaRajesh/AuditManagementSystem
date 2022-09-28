package com.cognizant.AuditAuthenticationMicroservice;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
/**
 * 
 * POD 2 -Audit Management System This is Application class for Spring boot
 * 
 * This Microservice is all about authentication Microservice
 *
 */

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.cognizant.AuditAuthenticationMicroservice.Model.ProjectManager;
import com.cognizant.AuditAuthenticationMicroservice.Repository.ProjectManagerRepository;

@SpringBootApplication
public class AuditAuthenticationMicroserviceApplication {

	/**
	 * repository is auto-wired
	 * 
	 */

	@Autowired
	ProjectManagerRepository repo;
	/**
	 * PasswordEncoder is auto-wired
	 * 
	 */
	@Autowired
	PasswordEncoder bcrpyt;

	public static void main(String[] args) {
		/**
		 * main Method- SpringBoot main method to launch an application.
		 */
		SpringApplication.run(AuditAuthenticationMicroserviceApplication.class, args);
	}

	/**
	 * post construct annotation is used to insert data into database at runtime
	 */
	@PostConstruct
	public void initUsers() {
		List<ProjectManager> users = Stream
				.of(new ProjectManager("Rajesh", bcrpyt.encode("rajesh"), " "),
						new ProjectManager("Vandana", bcrpyt.encode("vandana"), " "),
						new ProjectManager("Divya", bcrpyt.encode("divya"), " "),
						new ProjectManager("Kalyani", bcrpyt.encode("kalyani"), " "),
						new ProjectManager("Harshitha", bcrpyt.encode("harshitha"), " "),
						new ProjectManager("Deekshitha", bcrpyt.encode("deekshitha"), " "))
				.collect(Collectors.toList());
		repo.saveAll(users);
	}

}
