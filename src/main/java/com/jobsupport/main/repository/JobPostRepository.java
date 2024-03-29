package com.jobsupport.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobsupport.main.entity.JobPost;

@Repository
public interface JobPostRepository extends JpaRepository<JobPost, String>{

	@Query("select j from JobPost j where j.email=?1")
	List<JobPost> findBymail(String email);

	@Query("select count(j) from JobPost j where j.status = ?1 and j.email = ?2")
	Long countByStatusAndEmail(String status, String email);

}
