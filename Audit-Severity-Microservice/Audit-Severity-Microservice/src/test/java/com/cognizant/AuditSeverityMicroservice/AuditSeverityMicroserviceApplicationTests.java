package com.cognizant.AuditSeverityMicroservice;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration
class AuditSeverityMicroserviceApplicationTests {

	@Mock
	AuditSeverityMicroserviceApplication app;
	
	@Test
	void contextLoads() {
		assertNotNull(app);
		
	}

}
