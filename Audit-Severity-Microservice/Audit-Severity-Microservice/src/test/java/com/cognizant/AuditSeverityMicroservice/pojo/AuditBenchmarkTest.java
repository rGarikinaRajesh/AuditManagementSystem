package com.cognizant.AuditSeverityMicroservice.pojo;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.cognizant.AuditSeverityMicroservice.Pojo.AuditBenchmark;
/**
 * 
 * 	Test class to test AuditBenchMark 
 *
 */
public class AuditBenchmarkTest {

	private AuditBenchmark benchmark;
	
	@Before
	public void setup() {
		benchmark = new AuditBenchmark();
	}
	/**
	 * to test getter and setter
	 */
	@Test
	public void testGetSetAuditType() {
		benchmark.setAudittype("Internal");
		assertEquals("Internal", benchmark.getAudittype());
	}
	/**
	 * to test getter and setter
	 */
	@Test
	public void testGetSetAccNoAnswers() {
		benchmark.setNoAnswers(12);
		assertEquals(12, benchmark.getNoAnswers());
	}
}
