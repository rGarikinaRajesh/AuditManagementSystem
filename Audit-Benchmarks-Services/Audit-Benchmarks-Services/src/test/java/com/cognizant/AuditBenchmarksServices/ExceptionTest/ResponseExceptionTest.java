package com.cognizant.AuditBenchmarksServices.ExceptionTest;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.cognizant.AuditBenchmarksServices.Exception.ResponseNullException;

@ContextConfiguration 
@SpringBootTest
public class ResponseExceptionTest {
	@Mock
	ResponseNullException responsenullexception;
	@Test
	public void contextLoads() {
		assertNotNull(responsenullexception);
	}
	
	@Test
	public void ResponseNullExceptiontest()
	{
		ResponseNullException exception=new ResponseNullException("Error Reponse");
		assertNotNull(exception);
	}
	
	

}
