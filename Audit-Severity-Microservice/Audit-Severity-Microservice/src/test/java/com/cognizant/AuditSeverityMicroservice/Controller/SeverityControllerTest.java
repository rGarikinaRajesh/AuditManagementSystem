package com.cognizant.AuditSeverityMicroservice.Controller;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.AuditSeverityMicroservice.FeignClient.AuditBenchmarkFeignclient;
import com.cognizant.AuditSeverityMicroservice.FeignClient.AuditCheckListProxy;
import com.cognizant.AuditSeverityMicroservice.FeignClient.AuthClient;
import com.cognizant.AuditSeverityMicroservice.Pojo.AuditBenchmark;
import com.cognizant.AuditSeverityMicroservice.Pojo.AuditDetails;
import com.cognizant.AuditSeverityMicroservice.Pojo.AuditRequest;
import com.cognizant.AuditSeverityMicroservice.Pojo.AuditResponse;
import com.cognizant.AuditSeverityMicroservice.Pojo.AuditType;
import com.cognizant.AuditSeverityMicroservice.Pojo.QuestionsEntity;
import com.cognizant.AuditSeverityMicroservice.Service.AuditRequestResponse;
import com.cognizant.AuditSeverityMicroservice.Service.TokenService;


@ContextConfiguration
@SpringBootTest
public class SeverityControllerTest {

	@Mock
	private AuditRequestResponse service;
	
	@Mock
	AuthClient authClient;
	
	@Mock
	AuditCheckListProxy checklistProxy;
	
	
	@Mock
	TokenService tokenService;
	
	@Mock
	AuditBenchmarkFeignclient auditBenchmarkFeignclient;
	
	@Mock
	Environment env;
	
	@InjectMocks
	SeverityController severityController;
	
	@Test
	public void contextLoad() {
		assertNotNull(severityController);
	}

	@Test
	public void testAuditSeverity() {
		List<QuestionsEntity> questionsEntity = new ArrayList<>();
		questionsEntity.add(new QuestionsEntity(1,"Internal","ABC","No"));
		questionsEntity.add(new QuestionsEntity(1,"Internal","DEF","No"));
		questionsEntity.add(new QuestionsEntity(1,"Internal","PQR","Yes"));
		questionsEntity.add(new QuestionsEntity(1,"Internal","STU","Yes"));
		questionsEntity.add(new QuestionsEntity(1,"Internal","QWF","Yes"));

		ResponseEntity<List<QuestionsEntity>> questionsList = new ResponseEntity<List<QuestionsEntity>>(questionsEntity,HttpStatus.OK);
		List<AuditBenchmark> auditBenchmarkList = new ArrayList<AuditBenchmark>();
		auditBenchmarkList.add(new AuditBenchmark("Internal", 3));
		auditBenchmarkList.add(new AuditBenchmark("SOX", 1));
		ResponseEntity<List<AuditBenchmark>> responseEntity = new ResponseEntity<List<AuditBenchmark>>(auditBenchmarkList,HttpStatus.OK);
		AuditType auditType = new AuditType("Internal");
		when(tokenService.checkTokenValidity("token")).thenReturn(true);
		when(auditBenchmarkFeignclient.getBenchmarkMap("token")).thenReturn(responseEntity);
		when(checklistProxy.getChecklist("token", auditType)).thenReturn(questionsList);
		AuditResponse auditResponse = new AuditResponse(env.getProperty("project.status.green"),env.getProperty("remedial.action.no"));
		
		//assertNull(severityController.auditSeverity("token", new AuditRequest("P","Q","R",null,new AuditDetails("Internal",null))).getBody());
	}
	
	@Test
	public void testAuditSeverityTokenFails() {
		when(tokenService.checkTokenValidity("token")).thenReturn(false);
		assertEquals(HttpStatus.FORBIDDEN,severityController.auditSeverity("token", new AuditRequest("P","Q","R",null,new AuditDetails("Internal",null))).getStatusCode());

	}
	
}
