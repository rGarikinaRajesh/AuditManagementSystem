package com.cognizant.AuditChecklistServices.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @version 1.8 This class is an entity which we will be storing in the
 *          database.
 * 
 */
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Question {
	/**
	 * This will be the question id for the questions
	 */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questionId;
	/**
	 * This will be the auditType for the questions
	 */
	@Column
	private String audittype;
	/**
	 * This will be the questions
	 */
	@Column
	private String Question;
	/**
	 * This will be the response for the question
	 */
	@Column
	private String response;

}
