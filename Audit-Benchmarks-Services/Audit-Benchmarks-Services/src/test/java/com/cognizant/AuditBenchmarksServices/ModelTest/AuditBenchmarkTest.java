package com.cognizant.AuditBenchmarksServices.ModelTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.AuditBenchmarksServices.Model.AuditBenchmark;

@SpringBootTest
public class AuditBenchmarkTest {

	private AuditBenchmark benchmark;
	private AuditBenchmark benchmarkCheck;

	@BeforeEach
	public void setup() {
		benchmark = new AuditBenchmark();
		benchmarkCheck = new AuditBenchmark("Internal",20);
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
		benchmark.setNoAnswers(10);
		assertEquals(10, benchmark.getNoAnswers());
		assertNotNull(benchmarkCheck);
	}

}
