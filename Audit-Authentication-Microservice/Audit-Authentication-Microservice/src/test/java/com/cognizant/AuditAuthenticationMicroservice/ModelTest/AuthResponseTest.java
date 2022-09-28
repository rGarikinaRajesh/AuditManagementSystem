package com.cognizant.AuditAuthenticationMicroservice.ModelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.cognizant.AuditAuthenticationMicroservice.Model.AuthResponse;


public class AuthResponseTest {
	 
	    
	 
	    /**
	     * to test getter and setter
	     */
	    @Test
	    public void testGetUid() {
	    	AuthResponse  auth = new AuthResponse();
	    	assertNotNull(auth);
	        auth.setUid("UID");
	        assertEquals("UID", auth.getUid());
	    }
	    /**
	     * to test getter and setter
	     */
	    @Test
	    public void testsetValid() {
	    	AuthResponse  auth = new AuthResponse();
	        auth.setValid(false);
	        assertFalse(auth.isValid());
	    }
	    
	   @Test
	   public void NoArgconstructortest()
	   {
		   AuthResponse  auth = new AuthResponse("abc",true);
		   assertNotNull(auth);
	   }
	   @Test
	   public void AllArgconstructortest()
	   {
		   AuthResponse  auth = new AuthResponse("uid",false);
		   assertNotNull(auth);
		   assertEquals("uid", auth.getUid());
		   assertEquals(false, auth.isValid());
	   }
	    

}
