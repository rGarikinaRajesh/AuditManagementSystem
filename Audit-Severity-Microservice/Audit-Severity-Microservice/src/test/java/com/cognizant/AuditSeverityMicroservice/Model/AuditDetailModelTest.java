package com.cognizant.AuditSeverityMicroservice.Model;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
/**
 * 
 * 	Test case to test AuditDetailModel Class
 *
 */
public class AuditDetailModelTest {

	private AuditDetailModel detailModel;
	
	@Before
	public void setup() {
		detailModel = new AuditDetailModel();
	}
	
	@Test
	public void constructor() {
	int auditId;
	String auditType;
	Date auditDate; 
     auditId = 1;
    auditType = "Internal";
   auditDate = new Date();
	detailModel=new AuditDetailModel(auditId,auditType,auditDate);	
	assertEquals(auditId,detailModel.getAuditId());
	assertEquals(auditType,detailModel.getAudittype());
	assertEquals(auditDate,detailModel.getAuditDate());
	}
	
	@Test
	public void testGetSetAuditType() {
		detailModel.setAudittype("Internal");
		assertEquals("Internal", detailModel.getAudittype());
	}
	@Test
	public void testGetSetAuditDate() {
		Date date = new Date();
		detailModel.setAuditDate(date);
		assertEquals(date, detailModel.getAuditDate());
	}
	@Test
	public void testGetAuditId() {
		assertEquals(0, detailModel.getAuditId());
	}
}
