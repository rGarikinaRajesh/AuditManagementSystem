package com.cognizant.AuditChecklistServices.Exception;


import static org.junit.jupiter.api.Assertions.assertNotNull;

//import org.junit.Test;
import  org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

/**
 * This class tests the  class TokenNotValidExceptionTest
 */
@ContextConfiguration 
@SpringBootTest
public class TokenNotValidExceptionTest {

	@Mock
	TokenNotValidException handler;
	
	@Test
	public void contextLoads() {
		assertNotNull(handler);
	}
	
	@Test 
	public void testConstructor() {
		assertNotNull(new TokenNotValidException("Exception"));
	}
}
