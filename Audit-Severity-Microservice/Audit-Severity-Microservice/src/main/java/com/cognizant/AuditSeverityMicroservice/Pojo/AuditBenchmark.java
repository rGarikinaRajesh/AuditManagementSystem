package com.cognizant.AuditSeverityMicroservice.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * This POJO class is for AuditBenchMark
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AuditBenchmark {

	/**
	 * Variable auditType is used to store the type of Audit
	 */
	private String audittype;
	/**
	 * Variable NoAnswers is used to store the No Answers
	 */
	private int NoAnswers;

}
