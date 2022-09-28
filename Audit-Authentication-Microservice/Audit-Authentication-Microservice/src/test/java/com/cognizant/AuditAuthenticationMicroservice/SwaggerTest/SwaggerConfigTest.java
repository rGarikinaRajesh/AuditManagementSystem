package com.cognizant.AuditAuthenticationMicroservice.SwaggerTest;


import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.AuditAuthenticationMicroservice.Swagger.SwaggerConfig;

@ContextConfiguration
@SpringBootTest
class SwaggerConfigTest {

	@Mock
	SwaggerConfig config;

	@Test
	public void swaggerLoadtest() {
		assertNotNull(config);
	}
	
	@Test
	public void SwaggerApiTest()
	{
		assertNull(config.api());
	}


}
