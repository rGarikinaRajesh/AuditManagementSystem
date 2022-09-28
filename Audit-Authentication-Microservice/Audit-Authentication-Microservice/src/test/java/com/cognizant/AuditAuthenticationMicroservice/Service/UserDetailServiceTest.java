package com.cognizant.AuditAuthenticationMicroservice.Service;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.AuditAuthenticationMicroservice.Model.ProjectManager;
import com.cognizant.AuditAuthenticationMicroservice.Repository.ProjectManagerRepository;

@SpringBootTest
@ContextConfiguration
class UserDetailServiceTest {

	@InjectMocks
	UserDetailsServiceClass userservice;
	
	@Mock
	ProjectManagerRepository repo;
	
	@Test
	void contextLoads() {
		assertNotNull(userservice);
		
	}
	
	@Test
	public void TestLoadUserByname()
	{
		assertThrows(NoSuchElementException.class,()->userservice.loadUserByUsername("abc"));
	}

	@Test
	public void savingUser()
	{
		ProjectManager manager=new ProjectManager("abc","abc"," ");
		int a=userservice.saveUser(manager);
		assertEquals(1,a);
	}
	
	@Test
	public void loadUserByUsernameTest() {
		
		ProjectManager user1=new ProjectManager("admin","admin",null);
		Optional<ProjectManager> data =Optional.of(user1) ;
		when(userservice.findById("admin")).thenReturn(data);
		UserDetails loadUserByUsername2 = userservice.loadUserByUsername("admin");
		assertNotNull(loadUserByUsername2.getUsername());
	}
	
}
