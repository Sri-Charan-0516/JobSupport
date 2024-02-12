package com.jobsupport.main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobPostDto {
	
	private String jobtitle;
	private String description;
	private String skills;
	private String duration;
	private String email;
	private String status;
}
