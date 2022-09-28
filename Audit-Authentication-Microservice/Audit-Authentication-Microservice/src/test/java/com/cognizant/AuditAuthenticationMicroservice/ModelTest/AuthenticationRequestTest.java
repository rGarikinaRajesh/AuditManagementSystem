package com.cognizant.AuditAuthenticationMicroservice.ModelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.AuditAuthenticationMicroservice.Model.AuthenticationRequest;

@SpringBootTest
public class AuthenticationRequestTest {
	AuthenticationRequest authenticationrequest = new AuthenticationRequest();

	/**
	 * to test the all param constructor of userRetail
	 */
	@Test
	public void testAuthenticationRequestAllConstructor() {
		AuthenticationRequest authenticationrequest = new AuthenticationRequest("abc", "123");
		assertEquals("abc", authenticationrequest.getUsername());
	}

	/**
	 * to test the getter setter of Uid
	 */
	@Test
	public void testUsername() {
		authenticationrequest.setUsername("abc");
		assertEquals("abc",authenticationrequest.getUsername());
	}

	/**
	 * to test the getter setter of UserPassword
	 */
	@Test
	public void testUserPassword() {
		authenticationrequest.setPassword("abc");
		assertEquals("abc", authenticationrequest.getPassword());
	}

	/**
	 * to test the getter setter of AuthToken
	 */

	/**
	 * to test the toString
	 */
	@Test
	public void testoString() {
		String string = authenticationrequest.toString();
		assertEquals(string, authenticationrequest.toString());
	}

}
