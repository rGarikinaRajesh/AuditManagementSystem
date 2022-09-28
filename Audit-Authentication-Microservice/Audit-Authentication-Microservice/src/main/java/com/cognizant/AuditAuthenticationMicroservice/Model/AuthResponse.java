package com.cognizant.AuditAuthenticationMicroservice.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

	/**
	 * uid stores the username 
	 */
	private String uid;
	/**
	 * isValid stores either true or false 
	 */
	private boolean isValid;
}
