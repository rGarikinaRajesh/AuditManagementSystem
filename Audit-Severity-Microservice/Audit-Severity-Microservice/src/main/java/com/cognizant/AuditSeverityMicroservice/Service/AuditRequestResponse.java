package com.cognizant.AuditSeverityMicroservice.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.AuditSeverityMicroservice.Model.AuditDetailModel;
import com.cognizant.AuditSeverityMicroservice.Model.AuditRequestModel;
import com.cognizant.AuditSeverityMicroservice.Model.AuditResponseModel;
import com.cognizant.AuditSeverityMicroservice.Pojo.AuditRequest;
import com.cognizant.AuditSeverityMicroservice.Pojo.AuditResponse;
import com.cognizant.AuditSeverityMicroservice.Repository.RequestRepository;
import com.cognizant.AuditSeverityMicroservice.Repository.ResponseRepository;

@Service
public class AuditRequestResponse {

	@Autowired
	private RequestRepository requestRepository;
	@Autowired
	private ResponseRepository responseRepository;

	/**
	 * 
	 * @param request
	 * @return AuditRequestModel
	 */
	public AuditRequestModel saveRequest(AuditRequest request) {
		AuditRequestModel requestModel = new AuditRequestModel();
		AuditDetailModel auditDetailModel = new AuditDetailModel(request.getAuditDetails().getAudittype());
		requestModel.setAuditDetail(auditDetailModel);
		requestModel.setProjectName(request.getProjectName());
		requestModel.setManagerName(request.getProjectManagerName());
		requestModel.setOwnerName(request.getApplicationOwnerName());
		return requestRepository.save(requestModel);
	}

	/**
	 * 
	 * @param response
	 * @return AuditResponseModel
	 */
	public AuditResponseModel saveResponse(AuditResponse response) {
		AuditResponseModel responseModel = new AuditResponseModel(response.getProjectExecutionStatus(),
				response.getRemedialActionDuration());
		return responseRepository.save(responseModel);
	}

}