package com.cognizant.AuditChecklistServices.ServiceTest;

//import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
//import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.AuditChecklistServices.Entity.Question;
import com.cognizant.AuditChecklistServices.Exception.AuditTypeNotFoundException;
import com.cognizant.AuditChecklistServices.Exception.TokenNotValidException;
import com.cognizant.AuditChecklistServices.Feign.FeignChecklist;
import com.cognizant.AuditChecklistServices.Model.AuthResponse;
import com.cognizant.AuditChecklistServices.Repository.AuditRepository;
import com.cognizant.AuditChecklistServices.service.checklistService;

import feign.FeignException;

/**
 *
 * This class contains test cases for the QuestionsService class which are
 * written using junit and mockito
 *
 */
@ContextConfiguration
@SpringBootTest
public class checklistServiceTest {

	@Mock
	AuditRepository questionsRespository;
	@InjectMocks
	checklistService questionsService;
	@Mock
	FeignChecklist authClient;
	@Mock
	AuthResponse authResponse;
	@Mock
	Environment env;
	@Mock
	ResponseEntity<AuthResponse> entity;

	/**
	 * test to check whether it returns a list
	 * 
	 * @throws IndexOutOfBoundsException
	 */
	@Test
	public void testGetQuestionsList() throws IndexOutOfBoundsException {
		List<Question> questions = new ArrayList<>();
		questions.add(new Question(1, "Internal", "Have all Change requests followed SDLC before PROD move?", "Yes"));
		when(questionsRespository.findByAudittype("Internal")).thenReturn(questions);
		assertEquals(questions, questionsService.getQuestions("Internal"));
	}

	/**
	 * test questions when list throws IndexOutOfBoundsException
	 */
	@Test
	public void testQuestionsListthrowsAuditTypeNotFoundException() {
		when(questionsRespository.findByAudittype("Internal"))
				.thenThrow(new AuditTypeNotFoundException("Audit Type Not Found"));
		assertThrows(AuditTypeNotFoundException.class, () -> questionsService.getQuestions("Internal"));
	}

	/**
	 * test to check the validity of token when token is valid
	 * 
	 * @throws TokenNotValidException
	 * @throws FeignException
	 */
	@Test
	public void testCheckTokenValidityWhenTokenIsValid() throws FeignException, TokenNotValidException {
		entity = new ResponseEntity<AuthResponse>(new AuthResponse(null, true), HttpStatus.OK);
		when(authClient.getValidity("token")).thenReturn(entity);

		assertEquals(true, questionsService.getValidity("token"));

	}

}