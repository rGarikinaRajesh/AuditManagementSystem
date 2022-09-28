package com.cognizant.AuditBenchmarksServices.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.AuditBenchmarksServices.Model.AuthResponse;

@FeignClient(name = "audit-bench-mark", url = "http://localhost:8080")
public interface AuthClient {

	/**
	 * This establishes communication with Authentication microservice
	 */
	@GetMapping("/validate")
	public ResponseEntity<AuthResponse> getValidity(@RequestHeader("Authorization") String token);

}
