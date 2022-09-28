package com.cognizant.AuditChecklistServices;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AuditChecklistServicesApplicationTests {

	@Mock
	AuditChecklistServicesApplication app;
	@Test
	void contextLoads() {
		assertNotNull(app);
	}

}
