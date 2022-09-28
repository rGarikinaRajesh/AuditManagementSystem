package com.cognizant.AuditSeverityMicroservice.pojo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.mockito.Mock;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.AuditSeverityMicroservice.Pojo.AuditType;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * 	Test class to test AuditType
 *
 */

@ContextConfiguration @Slf4j
public class AuditTypeTest {

	AuditType auditType = new AuditType();
	
	@Mock
	Environment env;
	/**
	 * to test the all param constructor of AuditType
	 */
	@Test
	public void testAuditTypeAllConstructor() {
		log.info(env.getProperty("string.start"));
		AuditType type = new AuditType("abc");
		assertEquals(type.getAudittype(), "abc");
		log.info(env.getProperty("string.end"));
	}
	/**
	 * to test the getter setter of AuditType
	 */
	@Test
	public void testGetAuditType() {
		log.info(env.getProperty("string.start"));
		auditType.setAudittype("abc");
		assertEquals(auditType.getAudittype(), "abc");
		log.info(env.getProperty("string.end"));
	}
	
	
	/**
	 * to test the getter setter of toString()
	 */
	@Test
	public void testoString() {
		log.info(env.getProperty("string.start"));
		String string = auditType.toString();
		assertEquals(auditType.toString(), string);
		log.info(env.getProperty("string.end"));
	}

}
