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
 * This POJO class is for AuditDetails
 *
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AuditDetails {
	/**
	 * Variable auditType is used to store the type of Audit
	 */
	private String audittype;
	/**
	 * Variable auditDate is used to store the Audit Date
	 */
	private Date auditDate;

}
