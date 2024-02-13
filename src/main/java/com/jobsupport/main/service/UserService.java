package com.jobsupport.main.service;

import com.jobsupport.main.dto.ClientDto;
import com.jobsupport.main.entity.User;
import com.jobsupport.main.exceptions.InvalidUserIdException;

public interface UserService {
	
	public User addClient(ClientDto clientDto);
	
	public User updateClient(String email, User user) throws InvalidUserIdException;
	
	public User getClientDetails(String mail) throws InvalidUserIdException;
}
