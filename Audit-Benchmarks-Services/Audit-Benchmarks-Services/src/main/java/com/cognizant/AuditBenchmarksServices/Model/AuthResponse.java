package com.cognizant.AuditBenchmarksServices.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @version 1.8 This class is a model class which we will be used for storing
 *          username and token validity.
 * 
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {

	private String uid;
	private boolean isValid;
}
