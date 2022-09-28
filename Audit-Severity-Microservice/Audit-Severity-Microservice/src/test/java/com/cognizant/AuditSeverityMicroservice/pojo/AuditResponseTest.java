package com.cognizant.AuditSeverityMicroservice.pojo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cognizant.AuditSeverityMicroservice.Pojo.AuditResponse;
/**
 * 
 * Test class to test AuditResponse
 *
 */
public class AuditResponseTest {

	private AuditResponse response;
	
	@Before
	public void setup() {
		response = new AuditResponse("GREEN", "2 Weeks");
	}
	
	@Test
	public void testGetSetProjectExecutionStatus() {
		response.setProjectExecutionStatus("RED");
		assertEquals("RED", response.getProjectExecutionStatus());
	}
	@Test
	public void testGetSetRemedialActionDuration() {
		response.setRemedialActionDuration("None");
		assertEquals("None", response.getRemedialActionDuration());
	}
}
