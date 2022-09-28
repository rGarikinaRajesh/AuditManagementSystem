package com.cognizant.AuditBenchmarksServices.TestController;




import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.AuditBenchmarksServices.Controller.BenchMarkcontroller;
import com.cognizant.AuditBenchmarksServices.Model.AuditBenchmark;
import com.cognizant.AuditBenchmarksServices.Service.TokenService;
import com.cognizant.AuditBenchmarksServices.feign.AuthClient;

/**
 * 
 * Test class for BenchmarkController 
 */


@ContextConfiguration
@SpringBootTest
public class BenchMarkTestController {

	/**
	 * Mocking all required objects
	 */
	@Mock
	AuthClient authClient;
		
	@Mock
	TokenService tokenService;
	
	@Mock
	AuditBenchmark auditBenchmark;
	@InjectMocks
	BenchMarkcontroller controller;
	
	/**
	 * Testing the methods
	 */
	@Test
	public void testGetBenchmarkMap() {
		List<AuditBenchmark> auditBenchmarkList = new ArrayList<AuditBenchmark>();
		auditBenchmarkList.add(new AuditBenchmark("Internal", 3));
		auditBenchmarkList.add(new AuditBenchmark("SOX", 1));
		when(tokenService.checkTokenValidity("token")).thenReturn(true);
		assertNotNull(controller.getBenchmarkMap("token").getBody());
	}
	@Test
	public void testTokenInvalid() {
		when(tokenService.checkTokenValidity("token")).thenReturn(false);
		assertEquals(HttpStatus.FORBIDDEN,controller.getBenchmarkMap("token").getStatusCode());
	}	
}


