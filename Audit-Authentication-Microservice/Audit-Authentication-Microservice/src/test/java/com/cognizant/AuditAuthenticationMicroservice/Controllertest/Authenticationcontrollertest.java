package com.cognizant.AuditAuthenticationMicroservice.Controllertest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.AuditAuthenticationMicroservice.Controller.AuthenticationController;
import com.cognizant.AuditAuthenticationMicroservice.Model.ProjectManager;
import com.cognizant.AuditAuthenticationMicroservice.Model.UserCredentials;
import com.cognizant.AuditAuthenticationMicroservice.Repository.ProjectManagerRepository;
import com.cognizant.AuditAuthenticationMicroservice.Service.UserDetailsServiceClass;
import com.cognizant.AuditAuthenticationMicroservice.util.jwtUtil;

@SpringBootTest
@ContextConfiguration
class Authenticationcontrollertest {

	
	@Mock
	PasswordEncoder bcrypt;
	
	@InjectMocks
	AuthenticationController controller;

	@Mock
	UserDetailsServiceClass userservice;

	@Mock
	ProjectManagerRepository repo;

	@Mock
	jwtUtil jwtutil;

	@Mock
	AuthenticationManager authenticationManager;

	@Mock
	ProjectManager manager;

	@Mock
	UserCredentials user;
	
	@Test
	public void contextLoads()
	{
		assertNotNull(controller);
	}
	
	
	@Test
	public void allManagers()
	{
		List<ProjectManager> managers = controller.getManagers();
		assertNotNull(managers);
		
	}
	
	@Test
	public void TokenTest()
	{
		ResponseEntity<?> validity = controller.getValidity("Bearer.token");
		assertNotNull(validity);
		
		
		
	}
	
	@Test
	public void LoginTest()
	{
		UserCredentials user=new UserCredentials("Rajesh","rajesh");
		ResponseEntity<?> login = controller.login(user);
		assertNotNull(login);
	}
	


	@Test()
	public void validateTestInValidtoken() throws ServletException,IOException{
		when(jwtutil.validateToken("token")).thenReturn(false);
		ResponseEntity<?> validity = controller.getValidity("bearer token");
		assertEquals( false ,  validity.getBody().toString().contains("false") );
	}
	
	@Test
	public void testRegister()
	{
		AuthenticationController controller=mock(AuthenticationController.class);
		UserCredentials user=new UserCredentials("abc","abc");
		assertNotNull(controller.register(user));
	}
	
	
}
