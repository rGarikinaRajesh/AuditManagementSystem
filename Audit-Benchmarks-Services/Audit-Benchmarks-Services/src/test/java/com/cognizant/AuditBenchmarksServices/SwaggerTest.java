package com.cognizant.AuditBenchmarksServices;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.AuditBenchmarksServices.Swagger.SwaggerConfig;


@SpringBootTest
@ContextConfiguration
class SwaggerTest {

	@Mock
	SwaggerConfig config;
	
	@Test
	void test() {
		assertNotNull(config);
	}

}
