package com.cognizant.AuditSeverityMicroservice.Pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * This is a POJO Class for Questions Entity
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class QuestionsEntity {

	/**
	 * Variable questionId is used to store the QuestionID
	 */
	private Integer questionId;
	/**
	 * Variable auditType is used to store the Audit Type
	 */
	private String audittype;
	/**
	 * Variable question is used to store the Question
	 */
	private String question;
	/**
	 * Variable response is used to store the Response of the question
	 */
	private String response;

}
