package com.cognizant.AuditAuthenticationMicroservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuditAuthenticationMicroserviceApplicationTests {

	@Mock
	AuditAuthenticationMicroserviceApplication app;
	
	@Test
	void contextLoads() {
		
		assertNotNull(app);
		
	}

}
