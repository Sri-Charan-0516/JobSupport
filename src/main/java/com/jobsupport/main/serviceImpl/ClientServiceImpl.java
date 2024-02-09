package com.jobsupport.main.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import com.jobsupport.main.dto.JobPostDto;
import com.jobsupport.main.entity.JobPost;
import com.jobsupport.main.repository.JobPostRepository;
import com.jobsupport.main.service.ClientService;

@Service
public class ClientServiceImpl implements ClientService{
	
	@Autowired
	private JobPostRepository  jobPostRepository;
	
	@Override
	public JobPost postJob(JobPostDto jobPostDto) {
		JobPost jobPost=JobPost.builder()
				.jobtitle(jobPostDto.getJobtitle())
				.description(jobPostDto.getDescription())
				.skills(jobPostDto.getSkills())
				.duration(jobPostDto.getDuration())
				.email(jobPostDto.getEmail())
				.status(jobPostDto.getStatus())
				.build();
		return jobPostRepository.save(jobPost);
	}

	@Override
	public List<JobPost> getAllJobs(String email) {
		List<JobPost> list = jobPostRepository.findBymail(email);
		return list;
	}

	@Override
	public long getTotalJobsPosted(String mail) throws Exception {
		List<JobPost> list = jobPostRepository.findBymail(mail);
		if(list.isEmpty()) {
			throw new Exception("No Jobs Posted...!!!");
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
	
}
