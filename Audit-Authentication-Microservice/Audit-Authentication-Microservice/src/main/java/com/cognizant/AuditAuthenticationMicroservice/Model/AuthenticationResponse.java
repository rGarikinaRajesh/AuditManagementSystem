package com.cognizant.AuditAuthenticationMicroservice.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuthenticationResponse {

	/**
	 * jwt variable stores the jwt token
	 */
	private String jwt;

}
