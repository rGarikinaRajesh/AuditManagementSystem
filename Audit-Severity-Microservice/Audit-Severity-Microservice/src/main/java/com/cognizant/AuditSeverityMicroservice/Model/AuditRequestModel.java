package com.cognizant.AuditSeverityMicroservice.Model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "auditrequest")
public class AuditRequestModel {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RequestId")
	private int requestId;
	@OneToOne(cascade = CascadeType.ALL)
	private AuditDetailModel auditDetail;
	@Column(name = "ProjectName")
	private String projectName;
	@Column(name = "ManagerName")
	private String managerName;
	@Column(name = "OwnerName")
	private String ownerName;

	public AuditRequestModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public AuditDetailModel getAuditDetail() {
		return auditDetail;
	}

	public void setAuditDetail(AuditDetailModel auditDetail) {
		this.auditDetail = auditDetail;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getManagerName() {
		return managerName;
	}

	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public AuditRequestModel(AuditDetailModel auditDetail, String projectName, String managerName,
			String applicationOwnerName) {

		super();
		this.auditDetail = auditDetail;
		this.projectName = projectName;
		this.managerName = managerName;
		this.ownerName = applicationOwnerName;
	}

}