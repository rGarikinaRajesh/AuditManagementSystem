package com.cognizant.AuditSeverityMicroservice.Service;

import java.util.Date;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.AuditSeverityMicroservice.Model.AuditResponseModel;
import com.cognizant.AuditSeverityMicroservice.Pojo.AuditDetails;
import com.cognizant.AuditSeverityMicroservice.Pojo.AuditRequest;
import com.cognizant.AuditSeverityMicroservice.Pojo.AuditResponse;
import com.cognizant.AuditSeverityMicroservice.Repository.RequestRepository;
import com.cognizant.AuditSeverityMicroservice.Repository.ResponseRepository;

import lombok.extern.slf4j.Slf4j;
/**
 * 
 * 			Test class to test AuditRequestResponse
 *
 */
@SpringBootTest
@ContextConfiguration @Slf4j
public class AuditRequestResponseTest {

	@Mock
	RequestRepository requestRepository;
	@Mock
	ResponseRepository responseRepository;
	
	@InjectMocks
	AuditRequestResponse requestResponse;
	
	@Mock
	Environment env;
	
	@Test
	public void saveRequest() {
		AuditDetails auditDetailModel = new AuditDetails("Internal",new Date());
		AuditRequest requestModel = new AuditRequest("AuditManagement","teja","Dharani",null,auditDetailModel);
		//assertEquals(null, requestResponse.saveRequest(requestModel));
	}
	@Test
	public void saveResponseTest() {
		AuditResponse response = new AuditResponse("GREEN","No action required");
		AuditResponseModel detailModel = new AuditResponseModel(response.getProjectExecutionStatus(),response.getRemedialActionDuration());
		//when(responseRepository.save(detailModel)).thenReturn(detailModel);
		//assertNotEquals(detailModel, requestResponse.saveResponse(response));
	}
}
