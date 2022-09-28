package com.cognizant.AuditBenchmarksServices.TestConfig;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.AuditBenchmarksServices.Swagger.SwaggerConfig;
@ContextConfiguration 
@SpringBootTest
public class SwaggerConfigTest {
	@InjectMocks
	SwaggerConfig config;
	
	@Test
	public void contextLoads() {
		assertNotNull(config);
	}
	

	@Test
	public void testDocket() {
		assertNotNull(config.api());
	}

}