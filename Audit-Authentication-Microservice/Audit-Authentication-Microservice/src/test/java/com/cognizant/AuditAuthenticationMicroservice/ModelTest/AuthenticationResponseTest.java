package com.cognizant.AuditAuthenticationMicroservice.ModelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.cognizant.AuditAuthenticationMicroservice.Model.AuthenticationResponse;

public class AuthenticationResponseTest {
	AuthenticationResponse authenticationresponsetest = new AuthenticationResponse();

	@Test
	public void testAuthenticationResponseAllConstructor() {
		AuthenticationResponse authenticationresponsetest = new AuthenticationResponse("abc");
		assertEquals("abc", authenticationresponsetest.getJwt());
	}

	@Test
	public void setJwt() {
		authenticationresponsetest.setJwt("abc");
		assertEquals("abc", authenticationresponsetest.getJwt());
	}

}
