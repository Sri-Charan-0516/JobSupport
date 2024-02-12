package com.jobsupport.main.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobsupport.main.dto.JobCountDto;
import com.jobsupport.main.entity.JobPost;
import com.jobsupport.main.exceptions.InvalidIdException;
import com.jobsupport.main.service.ClientService;

@RestController
public class ClientController {
	
	@Autowired
	private ClientService clientService;
	
	@PostMapping("/post")
	public ResponseEntity<JobPost> postJob(@RequestBody JobPost jobPostDto) {
		return new ResponseEntity<JobPost>(clientService.postJob(jobPostDto),HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllJobs/{email}")
	public ResponseEntity<List<JobPost>> getAllJobs(@PathVariable String email) throws Exception{
		if(email!=null) {
			return new ResponseEntity<List<JobPost>>(clientService.getAllJobs(email),HttpStatus.ACCEPTED);
		}
		else {
			throw new Exception("Email cant be null..!!!");
		}
	}
	
	@GetMapping("/jobCounts/{mail}")
	public JobCountDto getJobCounts(@PathVariable String mail) throws Exception {
		long totalJobsPosted = clientService.getTotalJobsPosted(mail);
        long totalCompletedJobs = clientService.getTotalCompletedJobs(mail);
        long totalPendingJobs = clientService.getTotalPendingJobs(mail);
        return new JobCountDto(totalJobsPosted, totalCompletedJobs, totalPendingJobs);
	}
	
	@DeleteMapping("/delete/{title}")
	public ResponseEntity<String> deleteJob(@PathVariable String title) throws InvalidIdException{
		if(title.isEmpty()) {
			throw new InvalidIdException("Empty Title..!!!"); 
		}
		else {
			return new ResponseEntity<String>(clientService.deleteJob(title),HttpStatus.ACCEPTED); 
		}
	}
}
