package com.cognizant.AuditBenchmarksServices.service;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.AuditBenchmarksServices.Service.TokenService;
import com.cognizant.AuditBenchmarksServices.feign.AuthClient;

@ContextConfiguration
@SpringBootTest
class TokenServiceTest {

	@InjectMocks
	TokenService service;
	
	@Mock
	AuthClient client;
	
	@Test
	public void Validity()
	{
		assertThrows(NullPointerException.class,() -> service.checkTokenValidity(null));
		assertThrows(NullPointerException.class,() -> service.checkTokenValidity("token"));
	}
}
