package com.cognizant.AuditBenchmarksServices.ModelTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.AuditBenchmarksServices.Model.AuthResponse;

@SpringBootTest
public class AuditResponseTest {

	private AuthResponse authresponse;
	private AuthResponse authresponseCheck;

	@BeforeEach
	public void setup() {
		authresponse = new AuthResponse();
		authresponseCheck = new AuthResponse("uid",true);
	}

	/**
	 * to test getter and setter
	 */
	@Test
	public void testGetSetAuditType() {
		authresponse.setUid("uid");
		assertEquals("uid", authresponse.getUid());
	}

	/**
	 * to test getter and setter
	 */
	@Test
	public void testGetSetValid() {
		authresponse.setValid(false);
		assertEquals(false, authresponse.isValid());
		assertNotNull(authresponseCheck);
	}

}
