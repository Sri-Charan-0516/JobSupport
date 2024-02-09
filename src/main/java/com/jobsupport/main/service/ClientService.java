package com.jobsupport.main.service;

import java.util.List;

import com.jobsupport.main.dto.JobPostDto;
import com.jobsupport.main.entity.JobPost;

public interface ClientService {
	JobPost postJob(JobPostDto jobPostDto);
	
	List<JobPost> getAllJobs(String mail);
	
	public long getTotalJobsPosted(String mail) throws Exception ;

    public long getTotalCompletedJobs(String mail);

    public long getTotalPendingJobs(String mail);
}
