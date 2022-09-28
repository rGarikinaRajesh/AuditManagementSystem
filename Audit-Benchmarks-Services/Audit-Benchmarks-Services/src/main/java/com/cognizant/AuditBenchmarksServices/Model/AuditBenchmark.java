package com.cognizant.AuditBenchmarksServices.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * This class is used to handle audit type and acceptable no of NO allowed in
 * particular benchmark
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditBenchmark {

	private String Audittype;
	private int NoAnswers;

}
