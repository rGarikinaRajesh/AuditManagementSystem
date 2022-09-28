package com.cognizant.AuditAuthenticationMicroservice.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ProjectManager {

	@Id
	@Column
	private String username;
	@Column
	private String password;
	@Column
	private String token;
}
