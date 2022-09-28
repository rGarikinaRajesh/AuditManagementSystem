package com.cognizant.AuditBenchmarksServices.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.AuditBenchmarksServices.Model.AuditBenchmark;
import com.cognizant.AuditBenchmarksServices.Service.TokenService;

/**
 * This class is handling the end point for returning benchmark of acceptable no
 * of NO's for a particular audit type to Audit Severity microservice.
 * 
 * @see AuthClient is used to verify the token.
 * @see tokenService is to check token with auth microservice
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class BenchMarkcontroller {

	@Autowired
	TokenService tokenService;

	/**
	 * 
	 * @param token
	 * @return This method is used to get the benchmark list
	 */
	@GetMapping("/AuditBenchmark")
	public ResponseEntity<?> getBenchmarkMap(@RequestHeader("Authorization") String token) {
		List<AuditBenchmark> auditBenchmarkList = new ArrayList<AuditBenchmark>();
		ResponseEntity<?> responseEntity = null;
		auditBenchmarkList.add(new AuditBenchmark("Internal", 3));
		auditBenchmarkList.add(new AuditBenchmark("SOX", 1));
		if (tokenService.checkTokenValidity(token)) {
			responseEntity = new ResponseEntity<List<AuditBenchmark>>(auditBenchmarkList, HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<String>("String token expired", HttpStatus.FORBIDDEN);
			return responseEntity;
		}
		return responseEntity;

	}

}
