package com.jobsupport.main.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.jobsupport.main.entity.JobPost;
import com.jobsupport.main.exceptions.InvalidIdException;
import com.jobsupport.main.exceptions.ResourceNotFoundException;
import com.jobsupport.main.repository.JobPostRepository;
import com.jobsupport.main.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private JobPostRepository  jobPostRepository;
	
	@Override
	public JobPost postJob(JobPost jobPost) {
		return jobPostRepository.save(jobPost);
	}

	@Override
	public List<JobPost> getAllJobs(String email) throws ResourceNotFoundException {
		List<JobPost> list = jobPostRepository.findBymail(email);
		if(list.isEmpty()) {
			throw new ResourceNotFoundException("No Jobs Found..!!!");
		}else return list;
	}

	@Override
	public long getTotalJobsPosted(String mail) throws ResourceNotFoundException {
		List<JobPost> list = jobPostRepository.findBymail(mail);
		if(list.isEmpty()) {
			throw new ResourceNotFoundException("No Jobs Posted...!!!");
		}
		else {
			return jobPostRepository.count();
		}
	}

	@Override
    public long getTotalCompletedJobs(String mail) {
        try {
            return jobPostRepository.countByStatusAndEmail("Completed", mail);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return 0; // Default value
        }
    }

    @Override
    public long getTotalPendingJobs(String mail) {
        try {
            return jobPostRepository.countByStatusAndEmail("Pending", mail);
        } catch (DataAccessException e) {
            e.printStackTrace();
            return 0; // Default value
        }
    }

	@Override
	public String deleteJob(String jobTitle) throws InvalidIdException {
		JobPost jobPost = jobPostRepository.findById(jobTitle).orElseThrow(()-> new InvalidIdException("No Works Found..!!"));
		jobPostRepository.delete(jobPost);
		return "Job Deleted...!!!";
	}

	@Override
	public JobPost getJob(String jobtitle) {
		JobPost post = jobPostRepository.findById(jobtitle).get();
		return post;
	}

	@Override
	public JobPost updateJob(String jobtitle, JobPost jobPost) throws InvalidIdException {
		JobPost post = jobPostRepository.findById(jobtitle).orElseThrow(()-> new InvalidIdException("No Title Found..!!"));
		post.setJobtitle(jobPost.getJobtitle());
		post.setDescription(jobPost.getDescription());
		post.setSkills(jobPost.getSkills());
		post.setDuration(jobPost.getDuration());
		post.setCurrency(jobPost.getCurrency());
		post.setPrice(jobPost.getPrice());
		post.setStatus(jobPost.getStatus());
		return jobPostRepository.save(post);
	}
	
}
