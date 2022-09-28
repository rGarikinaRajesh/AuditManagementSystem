package com.cognizant.AuditAuthenticationMicroservice.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@SpringBootTest
class utilTest {
	
	@Mock
	jwtUtil util;
	
	@Test
	public void contextLoads()
	{
		assertNotNull(util);
	}

	@Test
	public void tokenexpire()
	{
		Boolean tokenExpired = util.isTokenExpired("Bearer.token");
		assertEquals(false,tokenExpired);
		
	}

	@Test
	public void extractUsername()
	{
		String extractUsername = util.extractUsername("Bearer.token");
		assertNull(extractUsername);
		Date extractExpiration = util.extractExpiration("Rajesh.Token");
		assertNull(extractExpiration);
	}
	
	@Test
	public void extractClaims()
	{
		Object extractClaim = util.extractClaim("Rajesh.Token",null);
		assertNull(extractClaim);
	}
	
	@Test
	public void extractAllClaims()
	{
		Object extractClaim = util.extractAllClaims("Rajesh.Token");
		assertNull(extractClaim);
	}
	@Test
	public void tokenvalidate()
	{
		Boolean tokenExpired = util.validateToken("Bearer.token");
		when(util.validateToken("Bearer.token")).thenReturn(tokenExpired);
		assertEquals(false,tokenExpired);
		
	}

}
