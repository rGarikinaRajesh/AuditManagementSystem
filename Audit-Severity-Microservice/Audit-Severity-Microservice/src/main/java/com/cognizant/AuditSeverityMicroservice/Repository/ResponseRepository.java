package com.cognizant.AuditSeverityMicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.AuditSeverityMicroservice.Model.AuditResponseModel;

@Repository
public interface ResponseRepository extends JpaRepository<AuditResponseModel, Integer> {

}
