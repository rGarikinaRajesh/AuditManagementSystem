package com.cognizant.AuditSeverityMicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.AuditSeverityMicroservice.Model.AuditDetailModel;

@Repository
public interface DetailRepository extends JpaRepository<AuditDetailModel, Integer> {

}
