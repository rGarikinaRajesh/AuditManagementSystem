package com.cognizant.AuditChecklistServices.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.AuditChecklistServices.Entity.Question;
import com.cognizant.AuditChecklistServices.Exception.AuditTypeNotFoundException;
import com.cognizant.AuditChecklistServices.Exception.TokenNotValidException;
import com.cognizant.AuditChecklistServices.Feign.FeignChecklist;
import com.cognizant.AuditChecklistServices.Model.AuthResponse;
import com.cognizant.AuditChecklistServices.Repository.AuditRepository;

import feign.FeignException;

/**
 * used to provide services to the Controller
 */
@Service
public class checklistService {

	@Autowired
	AuditRepository repo;

	@Autowired
	FeignChecklist feign;

	/**
	 * @param audittype
	 * @return List<Question>
	 */
	public List<Question> getQuestions(String audittype) {
		List<Question> findByAudittype = repo.findByAudittype(audittype);
		if (findByAudittype.isEmpty()) {
			throw new AuditTypeNotFoundException("Audit Type Not Found");
		} else {
			return findByAudittype;
		}
	}

	/**
	 * @param token
	 * @return boolean this method will check the token validity by communicating
	 *         with FeignChecklist.
	 * @throws TokenNotValidException
	 */
	public Boolean getValidity(String token) throws FeignException, TokenNotValidException {
		try {
			if (token == null) {
				throw new NullPointerException();
			}
			AuthResponse body = feign.getValidity(token).getBody();
			if (body == null) {
				throw new TokenNotValidException("token not valid");
			}
		} catch (FeignException e) {
			return false;
		}
		return true;

	}

}
