package com.cognizant.AuditChecklistServices.EntityTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.AuditChecklistServices.Entity.AuditType;
/**
* 
*  	   This class contains test cases for the AuditType class
*         which are written using junit and mockito
*/
@SpringBootTest
public class AuditTypeTest {

	
	AuditType audittype = new AuditType();
	/**
	 * Test the AuditType Setter
	 */
	@Test
	public void testSetAuditType() {
		audittype.setAudittype("Internal");
		assertEquals("Internal",audittype.getAudittype());
	}
	/**
	 * Test the AuditType Getter
	 */
	@Test
	public void testGetAuditType() {
		audittype.setAudittype("SOX");
		assertEquals("SOX",audittype.getAudittype());
	}
	/**
	 * Test the AuditType All Args Constructor
	 */
	@Test
	public void testAuditTypeConstructor() {
		AuditType auditTypeTest = new AuditType("Sox");
		assertEquals("Sox",auditTypeTest.getAudittype());
	}
	/**
	 * Test the AuditType toString
	 */
	@Test
	public void testAuditTypeToString() {
		String s = new AuditType().toString();
		assertEquals(s,audittype.toString());
				
	}
	@Test
	public void testHashCode()
	{
		AuditType model=new AuditType();
		assertEquals(audittype.hashCode(), model.hashCode());
	}
	@Test
	public void testEquals1()
	{
		AuditType model=new AuditType();
		audittype=new AuditType();
		assertEquals(audittype,model);
	}
	@Test
	public void testEquals2()
	{
		AuditType model=new AuditType("Internal");
		audittype=new AuditType();
		assertNotEquals(model,audittype);
	}
	@Test
	public void testEquals3()
	{
		AuditType model=new AuditType();
		audittype=new AuditType("Internal");
		assertNotEquals(model, audittype);
	}
	@Test
	public void testEquals4() {
		audittype=new AuditType("Internal");
		AuditType model=audittype;
	assertEquals(audittype,model);
	}
	
}
