package com.cognizant.AuditChecklistServices.ModelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.cognizant.AuditChecklistServices.Model.AuthResponse;

public class AuthResponseTest {

	AuthResponse auth = new AuthResponse();

	/**
	 * to test getter and setter
	 */
	@Test
	public void testGetSetUid() {
		auth.setUid("UID");
		assertEquals("UID", auth.getUid());
	}

	/**
	 * to test getter and setter
	 */
	@Test
	public void testValid() {
		auth.setIsValid(false);
		assertFalse(auth.getIsValid());
	}

}