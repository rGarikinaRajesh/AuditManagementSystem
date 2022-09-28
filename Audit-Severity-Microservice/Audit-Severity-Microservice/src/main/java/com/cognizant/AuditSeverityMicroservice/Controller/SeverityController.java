package com.cognizant.AuditSeverityMicroservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.AuditSeverityMicroservice.FeignClient.AuditBenchmarkFeignclient;
import com.cognizant.AuditSeverityMicroservice.FeignClient.AuditCheckListProxy;
import com.cognizant.AuditSeverityMicroservice.FeignClient.AuthClient;
import com.cognizant.AuditSeverityMicroservice.Pojo.AuditBenchmark;
import com.cognizant.AuditSeverityMicroservice.Pojo.AuditRequest;
import com.cognizant.AuditSeverityMicroservice.Pojo.AuditResponse;
import com.cognizant.AuditSeverityMicroservice.Pojo.AuditType;
import com.cognizant.AuditSeverityMicroservice.Pojo.QuestionsEntity;
import com.cognizant.AuditSeverityMicroservice.Service.AuditRequestResponse;
import com.cognizant.AuditSeverityMicroservice.Service.TokenService;

import lombok.extern.slf4j.Slf4j;

/**
 * 
 * This class is handling all the end points for Audit Checklist microservice.
 * This controller has mappings as- postmapping-auditSeverity()
 *
 */

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class SeverityController {

	@Autowired
	private AuditRequestResponse service;
	@Autowired
	AuthClient authClient;
	@Autowired
	AuditCheckListProxy checklistProxy;

	@Autowired
	TokenService tokenService;

	@Autowired
	Environment env;

	@Autowired
	AuditBenchmarkFeignclient auditBenchmarkFeignclient;

	/**
	 * 
	 * @param token
	 * @param auditRequest
	 * @return ResponseEntity<Response>
	 */
	@PostMapping("/ProjectExecutionStatus")
	public ResponseEntity<?> auditSeverity(@RequestHeader(name = "Authorization", required = true) String token,
			@RequestBody AuditRequest auditRequest) {// ,@RequestBody Noscount count
		int accNoAnswers = 0, actualNoAnswers = 0;
		System.out.println("ar:  " + auditRequest);

		ResponseEntity<?> responseEntity = null;
		List<QuestionsEntity> questionsList = null;
		if (tokenService.checkTokenValidity(token)) {
			List<AuditBenchmark> benchmarkList = auditBenchmarkFeignclient.getBenchmarkMap(token).getBody();
			System.out.println(benchmarkList.get(1));
			System.out.println(benchmarkList.get(0));
			for (AuditBenchmark benchmark : benchmarkList) {
				if (benchmark.getAudittype().equalsIgnoreCase(auditRequest.getAuditDetails().getAudittype())) {
					accNoAnswers = benchmark.getNoAnswers();// 3-Internal
				}
			}
			AuditType auditType = new AuditType(auditRequest.getAuditDetails().getAudittype());
			questionsList = checklistProxy.getChecklist(token, auditType).getBody();
			List<QuestionsEntity> questionsData = auditRequest.getQuestionsData();

			for (QuestionsEntity answer : questionsData) {
				if (answer.getResponse().equalsIgnoreCase("No")) {
					actualNoAnswers++;
				}
			}
			if (actualNoAnswers <= accNoAnswers) {
				responseEntity = new ResponseEntity<AuditResponse>(new AuditResponse(
						env.getProperty("project.status.green"), env.getProperty("remedial.action.no")), HttpStatus.OK);
				AuditResponse response = (AuditResponse) responseEntity.getBody();
				service.saveResponse(response);
			} else if (auditRequest.getAuditDetails().getAudittype().equalsIgnoreCase("Internal")) {
				responseEntity = new ResponseEntity<AuditResponse>(
						new AuditResponse(env.getProperty("project.status.red"),
								env.getProperty("remedial.action.yes.one")),
						HttpStatus.OK);
				AuditResponse response = (AuditResponse) responseEntity.getBody();
				service.saveResponse(response);
			} else if (auditRequest.getAuditDetails().getAudittype().equalsIgnoreCase("SOX")) {
				responseEntity = new ResponseEntity<AuditResponse>(
						new AuditResponse(env.getProperty("project.status.red"),
								env.getProperty("remedial.action.yes.two")),
						HttpStatus.OK);
				AuditResponse response = (AuditResponse) responseEntity.getBody();
				service.saveResponse(response);
			}
			service.saveRequest(auditRequest);
			System.out.println("responseis" + responseEntity);
			return responseEntity;
		} else {
			log.error(env.getProperty("string.token.exp"));
			log.info(env.getProperty("string.end"));

			responseEntity = new ResponseEntity<String>(env.getProperty("string.token.exp"), HttpStatus.FORBIDDEN);
			return responseEntity;
		}
	}
}
