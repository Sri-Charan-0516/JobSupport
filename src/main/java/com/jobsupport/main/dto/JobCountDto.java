package com.jobsupport.main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobCountDto {
	private long totalJobsPosted;
    private long totalCompletedJobs;
    private long totalPendingJobs;
}
