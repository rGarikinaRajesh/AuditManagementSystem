package com.cognizant.AuditAuthenticationMicroservice.ExceptionTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.AuditAuthenticationMicroservice.Exception.TokenExpiredException;


@SpringBootTest
public class UserNotFoundTest {
	
	    TokenExpiredException handler=new  TokenExpiredException("UserNotFound");
	    
	  
		@Test
	    public void contextLoads() {
	        assertNotNull(handler);
	    }
	    
	    @Test 
	    public void testConstructor() {
	        assertNotNull(new TokenExpiredException("Exception"));
	    }

}
