package com.cognizant.AuditAuthenticationMicroservice.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class AuthenticationRequest {

	/**
	 * variable username stores username
	 */
	private String username;
	/**
	 * variable username stores username
	 */
	private String password;

}
