package com.cognizant.AuditAuthenticationMicroservice.ModelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cognizant.AuditAuthenticationMicroservice.Model.UserCredentials;

class UserCredentialsTest {

	UserCredentials loginCredential = new UserCredentials();
	/**
	 * to test the all param constructor of UserLoginCredential
	 */
	
	@Test
	public void testUserLoginCredentialAllConstructor() {
		UserCredentials credential = new UserCredentials("abc", "abc");
		assertEquals(credential.getUsername(), "abc");
		assertEquals(credential.getPassword(), "abc");
	}
	/**
	 * to test the getter setter of Uid
	 */
	@Test
	public void testGetUid() {
		loginCredential.setUsername("abc");
		assertEquals(loginCredential.getUsername(), "abc");
	}
	/**
	 * to test the getter setter of Password
	 */
	@Test
	public void testUserPassword() {
		loginCredential.setPassword("abc");
		assertEquals(loginCredential.getPassword(), "abc");
	}
	/**
	 * to test the getter setter of toString()
	 */
	@Test
	public void testoString() {
		String string = loginCredential.toString();
		assertEquals(loginCredential.toString(), string);
	}


}
