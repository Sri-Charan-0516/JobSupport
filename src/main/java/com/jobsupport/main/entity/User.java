package com.jobsupport.main.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;

	private String firstname;

	private String lastname;

	private long phonenumber;

	private String email;

	private String password;

	private String country;
	
	private LocalDate dob;
	
	private String gender;

	private String description;

	private String domain;
}
