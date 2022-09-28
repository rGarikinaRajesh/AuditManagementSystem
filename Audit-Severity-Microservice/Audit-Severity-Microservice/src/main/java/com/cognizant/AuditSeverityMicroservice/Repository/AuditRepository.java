package com.cognizant.AuditSeverityMicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.AuditSeverityMicroservice.Model.Question;

@Repository
public interface AuditRepository extends JpaRepository<Question, Integer> {

}
