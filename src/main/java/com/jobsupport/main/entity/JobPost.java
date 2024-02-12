package com.jobsupport.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class JobPost {
	
	@Id
	private String jobtitle;
	private String description;
	private String skills;
	private String duration;
	private String email;
	private String status;
	private String cuurency;
	private long price;
}
