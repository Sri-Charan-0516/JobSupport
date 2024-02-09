package com.jobsupport.main.jwt;

import com.jobsupport.main.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtResponse {
	private User user;
	private String jwtToken;
}
