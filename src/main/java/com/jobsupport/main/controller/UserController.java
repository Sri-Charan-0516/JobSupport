package com.jobsupport.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jobsupport.main.dto.ClientDto;
import com.jobsupport.main.entity.User;
import com.jobsupport.main.exceptions.InvalidUserIdException;
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
	
	@PutMapping("/update/{email}")
	public ResponseEntity<User> update(@PathVariable String email,@RequestBody User user) throws InvalidUserIdException{
		if(email!=null) {
			return new ResponseEntity<User>(userService.updateClient(email, user),HttpStatus.OK);
		}
		else {
			throw new InvalidUserIdException("Email cant be null..!!");
		}
	}
	
	@GetMapping("/getDetails/{email}")
	public ResponseEntity<User> getDetails(@PathVariable String email) throws InvalidUserIdException{
		if(email.isEmpty()) {
			throw new InvalidUserIdException("Email is empty..!!!");
		}
		else {
			return new  ResponseEntity<User>(userService.getClientDetails(email),HttpStatus.ACCEPTED);
		}
	}
}
