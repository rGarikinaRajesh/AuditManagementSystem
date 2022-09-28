package com.cognizant.AuditChecklistServices.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.AuditChecklistServices.Entity.AuditType;
import com.cognizant.AuditChecklistServices.Entity.Question;
import com.cognizant.AuditChecklistServices.Exception.TokenNotValidException;
import com.cognizant.AuditChecklistServices.Feign.FeignChecklist;
import com.cognizant.AuditChecklistServices.service.checklistService;

import feign.FeignException;

/**
 *
 * This class is handling all the end points for Audit Checklist microservice.
 * This controller has mappings as- postmapping-getQuestions()
 * getmapping-getAll() postmapping-saveResponses()
 *
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CheckListController {

	@Autowired
	checklistService service;

	@Autowired
	FeignChecklist feign;

	/**
	 *
	 * @param token
	 * @param auditType
	 * @return ResponseEntity<Response>
	 *
	 *         Returns the Questions according to the User's input whether he has
	 *         chosen Internal or SOX audit type
	 * @throws TokenNotValidException
	 * @throws FeignException
	 *
	 */
	@PostMapping("/AuditCheckListQuestions")
	public ResponseEntity<?> getQuestions(@RequestHeader("Authorization") String token,
			@RequestBody AuditType audittype) throws FeignException, TokenNotValidException {
		ResponseEntity<?> responseEntity = null;
		Boolean validity = service.getValidity(token);
		if (validity && !token.equals("Bearer.null")) {
			responseEntity = new ResponseEntity<List<Question>>(service.getQuestions(audittype.getAudittype()),
					HttpStatus.OK);
		} else {
			responseEntity = new ResponseEntity<String>("String token expired", HttpStatus.FORBIDDEN);
			return responseEntity;
		}
		return responseEntity;
	}

}
