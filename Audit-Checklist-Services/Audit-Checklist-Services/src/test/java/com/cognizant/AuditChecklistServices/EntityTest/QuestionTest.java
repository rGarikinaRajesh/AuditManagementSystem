package com.cognizant.AuditChecklistServices.EntityTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

//import org.junit.Test;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import com.cognizant.AuditChecklistServices.Entity.Question;

/**
 * 
 * This class contains test cases for the Question model class which are written
 * using junit and mockito
 */

@ContextConfiguration
@SpringBootTest
public class QuestionTest {

	Question questions = new Question();

	/**
	 * 
	 * test the allArgsConstructor of Question model class
	 */
	@Test
	public void testQuestionConstructor() {
		assertNotNull(questions);
	}

	/**
	 * 
	 * test the QuestionParameterizedConstructor of Question model class
	 */
	@Test
	public void testQuestionParameterizedConstructor() {
		Question parameterizedQuestions = new Question(1, "Internal", "Is data deleted with permission of user?",
				"Yes");
		assertEquals("Internal", parameterizedQuestions.getAudittype());
	}

	/**
	 * 
	 * test the Getter and Setter of Question id in Question model class
	 */
	@Test
	public void testSetQUestionId() {
		questions.setQuestionId(2);
		assertEquals(2, questions.getQuestionId());
	}

	/**
	 * 
	 * test the Getter and Setter of Audit Type in Question model class
	 */
	@Test
	public void testAuditType() {
		questions.setAudittype("SOX");
		assertEquals("SOX", questions.getAudittype());
	}

	/**
	 * 
	 * test the Getter and Setter of Question in Question model class
	 */
	@Test
	public void testQuestion() {
		questions.setQuestion("How are you");
		assertEquals("How are you", questions.getQuestion());
	}

	/**
	 * 
	 * test the Getter and Setter of Response in Question model class
	 */
	@Test
	public void testResponse() {
		questions.setResponse("No");
		assertEquals("No", questions.getResponse());
	}

	@Test
	public void testToString() {
		String str = questions.toString();
		assertEquals(str, questions.toString());
	}

}
