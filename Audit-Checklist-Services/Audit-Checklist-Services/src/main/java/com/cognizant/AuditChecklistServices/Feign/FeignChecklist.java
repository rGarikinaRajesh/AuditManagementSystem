package com.cognizant.AuditChecklistServices.Feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cognizant.AuditChecklistServices.Model.AuthResponse;

/**
 * This establishes communication with Authentication microservice
 */
@FeignClient(name = "Audit-Checklist", url = "http://localhost:8080")
public interface FeignChecklist {

	/**
	 * This is used to make request for token validation inside Authentication
	 * microservice
	 */
	@GetMapping("/validate")
	public ResponseEntity<AuthResponse> getValidity(@RequestHeader("Authorization") String token);

}
