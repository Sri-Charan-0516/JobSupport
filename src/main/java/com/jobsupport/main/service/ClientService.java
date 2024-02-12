package com.jobsupport.main.service;

import java.util.List;

import com.jobsupport.main.entity.JobPost;
import com.jobsupport.main.exceptions.InvalidIdException;
import com.jobsupport.main.exceptions.ResourceNotFoundException;

public interface ClientService {
	JobPost postJob(JobPost jobPost);
	
	List<JobPost> getAllJobs(String mail) throws ResourceNotFoundException;
	
	public long getTotalJobsPosted(String mail) throws Exception ;

    public long getTotalCompletedJobs(String mail);

    public long getTotalPendingJobs(String mail);
    
    public String deleteJob(String jobTitle) throws InvalidIdException;
}
