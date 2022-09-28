package com.cognizant.AuditAuthenticationMicroservice.Service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.cognizant.AuditAuthenticationMicroservice.Model.ProjectManager;
import com.cognizant.AuditAuthenticationMicroservice.Repository.ProjectManagerRepository;

@Service
public class UserDetailsServiceClass implements UserDetailsService {

	@Autowired
	ProjectManagerRepository repo;

	/**
	 * This method is used to load data from database for authentication
	 */
	@Override
	public UserDetails loadUserByUsername(String username) {
		Optional<ProjectManager> manager = repo.findById(username);
		ProjectManager projectManager = manager.get();
		return new User(projectManager.getUsername(), projectManager.getPassword(), new ArrayList<>());
	}

	/**
	 * 
	 * @param projectManager
	 * @return
	 * saving the user in database
	 */
	public int saveUser(ProjectManager projectManager) {
		repo.save(projectManager);
		return 1;

	}

	/**
	 * 
	 * @param id
	 * @return
	 * returns a record from database based on id
	 */
	public Optional<ProjectManager> findById(String id) {
		return repo.findById(id);
	}

}
