package com.cognizant.AuditSeverityMicroservice.Pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * Its a simple POJO class to store user details required by feign client
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class ProjectManager {

	/**
	 * This field will be used to store the userId
	 */
	private String userId;
	/**
	 * This field will be used to store the password
	 */
	private String password;
	/**
	 * This field will be used to store the authToken
	 *
	 */
	private String authToken;

}
