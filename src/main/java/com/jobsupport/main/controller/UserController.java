package com.jobsupport.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobsupport.main.dto.UserDto;
import com.jobsupport.main.service.UserService;

@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping
	public ResponseEntity<String> addClient(@RequestBody UserDto userDto) throws Exception {
		if(userDto==null) {
			throw new Exception("User Object cant be null...!!!");
		}
		else {
			return new ResponseEntity<String>(userService.addClient(userDto),HttpStatus.CREATED);
		}
	}
}
