package com.jobsupport.main.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
	private String firstname;

	private String lastname;

	private long phonenumber;

	private String email;

	private String password;

	private String role;

	private String country;
	
	private LocalDate dob;
	
	private String gender;
}
