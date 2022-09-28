package com.cognizant.AuditBenchmarksServices.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.AuditBenchmarksServices.Exception.ResponseNullException;
import com.cognizant.AuditBenchmarksServices.Model.AuthResponse;
import com.cognizant.AuditBenchmarksServices.feign.AuthClient;

@Service
public class TokenService {

	@Autowired
	AuthClient authclient;

	/**
	 * @param token
	 * @return boolean this method will check the token validity by communicating
	 *         with AuthClient.
	 */
	@SuppressWarnings("unused")
	public Boolean checkTokenValidity(String token) throws ResponseNullException {
		try {
			AuthResponse response = authclient.getValidity(token).getBody();
			return true;
		} catch (ResponseNullException e) {
			throw new ResponseNullException("Token not valid");
		}
	}
}
