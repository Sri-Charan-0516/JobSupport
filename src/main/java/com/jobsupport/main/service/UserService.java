package com.jobsupport.main.service;

import com.jobsupport.main.dto.ClientDto;
import com.jobsupport.main.entity.User;

public interface UserService {
	
	public User addClient(ClientDto clientDto);
	
	public User login(String email, String password) throws Exception;
}
