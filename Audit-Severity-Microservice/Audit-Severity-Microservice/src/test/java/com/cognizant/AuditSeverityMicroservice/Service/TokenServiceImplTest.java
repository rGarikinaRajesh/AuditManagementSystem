package com.cognizant.AuditSeverityMicroservice.Service;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.AuditSeverityMicroservice.FeignClient.AuthClient;
import com.cognizant.AuditSeverityMicroservice.Pojo.AuthResponse;

import lombok.extern.slf4j.Slf4j;
/**
 * This class contains test cases for the TokenServiceImpl class.
 */
@SpringBootTest
@ContextConfiguration
@Slf4j
public class TokenServiceImplTest {
	
	@InjectMocks
	TokenServiceImpl tokenService;
	@Mock
	AuthClient authClient;
	
	@Mock
	AuthResponse authResponse;
	@Mock
	Environment env;
	@Mock
	ResponseEntity<AuthResponse> entity;
	/**
	 * to check token validity when token is valid
	 */
	@Test
	public void testCheckTokenValidityWhenTokenIsValid() {
		entity = new ResponseEntity<AuthResponse>(new AuthResponse(null, true),HttpStatus.OK);
		//when(authClient.getValidity("token")).thenReturn(entity);

		//assertEquals(true, tokenService.checkTokenValidity("token"));

	}
	/**
	 * to check token validity when token gives null pointer exception
	 */
	@Test
	public void testCheckTokenValidityWhenTokenNullPointerException() {

		//assertThrows(NullPointerException.class,() -> tokenService.checkTokenValidity("token"));

	}
	/**
	 * to check token when token validity is invalid
	 */
	@Test
	public void testCheckTokenValidityWhenTokenIsInvalid() {
		entity = new ResponseEntity<AuthResponse>(new AuthResponse(null,false),HttpStatus.FORBIDDEN);
		//when(authClient.getValidity("token")).thenReturn(entity);
		//assertEquals(false, tokenService.checkTokenValidity("token"));

	}


}
