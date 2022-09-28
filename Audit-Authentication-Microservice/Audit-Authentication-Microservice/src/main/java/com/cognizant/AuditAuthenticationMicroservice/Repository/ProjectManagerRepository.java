package com.cognizant.AuditAuthenticationMicroservice.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.AuditAuthenticationMicroservice.Model.ProjectManager;

/**
 * 
 * This is an interface which is used to communicate with the database. Whatever
 * the data we want to fetch from database related to "ProjectManager" we can use
 * this interface for this purpose. This will extend "JpaRepository" which
 * is a JPA specific extension of Repository. It contains the full API of
 * CrudRepository.So it contains API for basic CRUD operations.
 */
@Repository
public interface ProjectManagerRepository extends JpaRepository<ProjectManager, String> {

}
