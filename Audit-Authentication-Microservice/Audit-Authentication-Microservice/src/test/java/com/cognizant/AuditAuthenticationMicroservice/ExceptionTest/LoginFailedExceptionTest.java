package com.cognizant.AuditAuthenticationMicroservice.ExceptionTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.AuditAuthenticationMicroservice.Exception.LoginFailedException;


@SpringBootTest
public class LoginFailedExceptionTest {
	
	   
	   LoginFailedException handler =new  LoginFailedException("LoginFailed");
	    
	    @Test
	    public void contextLoads() {
	        assertNotNull(handler);
	    }
	    
	    @Test 
	    public void testConstructor() {
	        assertNotNull(new LoginFailedException("Exception"));
	    }

}
