package com.cognizant.AuditChecklistServices.TestController;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

import com.cognizant.AuditChecklistServices.Controller.CheckListController;
import com.cognizant.AuditChecklistServices.Entity.AuditType;
import com.cognizant.AuditChecklistServices.Entity.Question;
import com.cognizant.AuditChecklistServices.Exception.TokenNotValidException;
import com.cognizant.AuditChecklistServices.Feign.FeignChecklist;
import com.cognizant.AuditChecklistServices.Repository.AuditRepository;
import com.cognizant.AuditChecklistServices.service.checklistService;

import feign.FeignException;

/**
 * This class contains test cases for the AuthController class which are written
 * using junit and mockito
 */
@ContextConfiguration
@SpringBootTest
public class CheckListControllerTest {

	@Mock
	FeignChecklist authClient;

	@Mock
	AuditType auditType;

	@Mock
	checklistService questionsService;

	@Mock
	Environment env;

	@InjectMocks
	CheckListController auditCheckListController;

	@Mock
	AuditRepository questionsRepository;

	@Test
	public void contextLoads() {
		assertNotNull(auditCheckListController);
	}

	/**
	 * To test testgetQuestions method
	 * 
	 * @throws TokenNotValidException
	 * @throws FeignException
	 */
	@Test
	public void testgetQuestions() throws FeignException, TokenNotValidException {
		ResponseEntity<?> responseEntity = null;
		List<Question> questionsList = new ArrayList<Question>();
		questionsList.add(new Question(1, "Internal", "How are you", "Yes"));
		when(questionsService.getValidity("token")).thenReturn(true);
		when(questionsService.getQuestions("Internal")).thenReturn(questionsList);
		responseEntity = auditCheckListController.getQuestions("token", auditType);
		assertNotNull(responseEntity);

	}

	/**
	 * To test testgetQuestionsTokenInvalid method
	 * 
	 * @throws TokenNotValidException
	 * @throws FeignException
	 */
	@Test
	public void testgetQuestionsTokenInvalid() throws FeignException, TokenNotValidException {
		ResponseEntity<?> responseEntity = null;
		when(questionsService.getValidity("token")).thenReturn(false);
		responseEntity = auditCheckListController.getQuestions("token", auditType);
		assertEquals(HttpStatus.FORBIDDEN, responseEntity.getStatusCode());
	}

}