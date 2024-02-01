package com.jobsupport.main.service;

import com.jobsupport.main.dto.ClientDto;
import com.jobsupport.main.entity.Client;

public interface ClientService {
	
	public Client addClient(ClientDto clientDto);
	
	public Client login(String email, String password) throws Exception;
}
