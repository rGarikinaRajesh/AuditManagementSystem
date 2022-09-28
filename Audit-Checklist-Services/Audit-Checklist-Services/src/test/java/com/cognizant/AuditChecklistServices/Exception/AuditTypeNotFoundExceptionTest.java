package com.cognizant.AuditChecklistServices.Exception;


import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

/**
 * This class tests the  class AuditTypeNotFoundExceptionTest
 */
public class AuditTypeNotFoundExceptionTest {
	
	
	@Test
	public void contextLoads() {
		
	}
	
	@Test 
	public void testConstructor() {
		assertNotNull(new AuditTypeNotFoundException("Audit Type not Found Exception"));
	}
}