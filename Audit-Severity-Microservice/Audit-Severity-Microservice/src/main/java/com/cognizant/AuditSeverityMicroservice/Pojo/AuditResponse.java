package com.cognizant.AuditSeverityMicroservice.Pojo;

/**
 * 
 * Variable auditDetails is used to store the AuditDetails of the Project
 *
 */
public class AuditResponse {

	private String projectExecutionStatus;
	private String remedialActionDuration;

	public AuditResponse(String projectExecutionStatus, String remedialActionDuration) {
		super();
		this.projectExecutionStatus = projectExecutionStatus;
		this.remedialActionDuration = remedialActionDuration;
	}

	public String getProjectExecutionStatus() {
		return projectExecutionStatus;
	}

	public void setProjectExecutionStatus(String projectExecutionStatus) {
		this.projectExecutionStatus = projectExecutionStatus;
	}

	public String getRemedialActionDuration() {
		return remedialActionDuration;
	}

	public void setRemedialActionDuration(String remedialActionDuration) {
		this.remedialActionDuration = remedialActionDuration;
	}

}
