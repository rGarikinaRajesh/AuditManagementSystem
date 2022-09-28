package com.cognizant.AuditSeverityMicroservice.Pojo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 
 * This is POJO class for AuditType
 *
 */

@EqualsAndHashCode

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AuditType {
	/**
	 * Variable auditType is used to store the Type of Audit
	 */
	private String audittype;

}
