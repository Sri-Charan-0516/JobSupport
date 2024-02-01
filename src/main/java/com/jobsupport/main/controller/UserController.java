package com.jobsupport.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobsupport.main.dto.ClientDto;
import com.jobsupport.main.entity.User;
import com.jobsupport.main.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/addClient")
	public ResponseEntity<User> addClient(@RequestBody ClientDto clientDto) throws Exception {
		if(clientDto==null) {
			throw new Exception("User Object cant be null...!!!");
		}
		else {
			return new ResponseEntity<User>(userService.addClient(clientDto),HttpStatus.CREATED);
		}
	}
	
	@PostMapping("/login/{email}/{password}")
	public ResponseEntity<User> login(@PathVariable String email,@PathVariable String password) throws Exception{
		return new ResponseEntity<User>(userService.login(email, password),HttpStatus.ACCEPTED);
	}
}
