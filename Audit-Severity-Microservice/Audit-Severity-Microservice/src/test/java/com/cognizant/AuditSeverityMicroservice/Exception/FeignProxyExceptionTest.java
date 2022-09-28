package com.cognizant.AuditSeverityMicroservice.Exception;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;


/**
 * 
 * This class test the FeignProxyException class
 * 
 *
 */
@SpringBootTest
@ContextConfiguration
public class FeignProxyExceptionTest{
	
	
	
	@Mock
	FeignProxyException feignProxyException;
	
	@Test
	public void contextLoads() {
		assertNotNull(feignProxyException);
	}
	
	

}
