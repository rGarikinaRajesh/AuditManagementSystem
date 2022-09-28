package com.cognizant.AuditChecklistServices.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.AuditChecklistServices.Entity.Question;

/**
 *
 * This interface communicates with db to fetch the questions.
 *
 */

@Repository
public interface AuditRepository extends JpaRepository<Question, Integer> {

	/**
	 *
	 * @param audittype
	 * @return List<Question>
	 */
	List<Question> findByAudittype(String audittype);

}
