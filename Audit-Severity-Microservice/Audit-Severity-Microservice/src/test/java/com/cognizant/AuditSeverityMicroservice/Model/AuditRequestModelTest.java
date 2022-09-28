package com.cognizant.AuditSeverityMicroservice.Model;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
/**
 * 
 * 	 to test AuditRequestModel Class
 *
 */
public class AuditRequestModelTest {

	private AuditRequestModel request;
	
	@Before
	public void setup() {
		request = new AuditRequestModel();
	}
	
	@Test
	public void testGetSetProjectName() {
		request.setProjectName("ProjectName");
		assertEquals("ProjectName", request.getProjectName());
	}
	@Test
	public void testGetSetProjectManagerName() {
		request.setManagerName("ManagerName");
		assertEquals("ManagerName", request.getManagerName());
	}
	@Test
	public void testGetSetOwnerName() {
		request.setOwnerName("OwnerName");
		assertEquals("OwnerName", request.getOwnerName());
	}
	@Test
	public void testGetRequestId() {
		assertEquals(0, request.getRequestId());
	}
	@Test
	public void constructor() {

		String auditType="Internal";
		Date auditDate=new Date();
		AuditDetailModel auditDetail = new AuditDetailModel(1,auditType,auditDate);
		String projectName = "AuditManagement";
		String managerName = "abc";
	    String ownerName = "ghi";
	    AuditRequestModel auditRequest=new AuditRequestModel(auditDetail,projectName,managerName,ownerName);
	    assertEquals(auditDetail,auditRequest.getAuditDetail());
	    assertEquals(projectName,auditRequest.getProjectName());
	    assertEquals(managerName,auditRequest.getManagerName());
	    assertEquals(ownerName,auditRequest.getOwnerName());
	    
	}
}
