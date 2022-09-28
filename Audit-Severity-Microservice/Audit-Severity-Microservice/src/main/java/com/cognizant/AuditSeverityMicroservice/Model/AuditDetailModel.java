package com.cognizant.AuditSeverityMicroservice.Model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "auditdetail")
public class AuditDetailModel {

	public AuditDetailModel(String audittype) {
		super();
		this.audittype = audittype;
	}

	public AuditDetailModel(int auditId, String audittype, Date auditDate) {
		super();
		this.auditId = auditId;
		this.audittype = audittype;
		this.auditDate = auditDate;
	}

	public AuditDetailModel() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "AuditId")
	private int auditId;
	@Column(name = "AuditType")
	private String audittype;
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "auditdate")
	private Date auditDate;

	@PrePersist
	protected void onCreate() {
		auditDate = new Date();
	}

	/*
	 * @Temporal(TemporalType.DATE)
	 * 
	 * @Column(name="AuditDate") private Date auditDate;
	 */
	public String getAudittype() {
		return audittype;
	}

	public void setAudittype(String audittype) {
		this.audittype = audittype;
	}

	public Date getAuditDate() {
		return auditDate;
	}

	public void setAuditDate(Date auditDate) {
		this.auditDate = auditDate;
	}

	public int getAuditId() {
		return auditId;
	}

}
