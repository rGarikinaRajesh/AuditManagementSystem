package com.cognizant.AuditSeverityMicroservice.pojo;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.cognizant.AuditSeverityMicroservice.Pojo.AuditDetails;
/**
 * 
 * 	Test class to test AuditDetails 
 *
 */
public class AuditDetailTest {

	private AuditDetails details;
	
	@Before
	public void setup() {
		details = new AuditDetails();
	}
	
	@Test
	public void testGetSetAuditType() {
		details.setAudittype("Internal");
		assertEquals("Internal", details.getAudittype());
	}
	
	@Test
	public void testGetSetAuditDate() {
		Date date = new Date();
		details.setAuditDate(date);
		assertEquals(date, details.getAuditDate());
	}
}
