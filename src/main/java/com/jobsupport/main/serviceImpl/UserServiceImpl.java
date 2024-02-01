package com.jobsupport.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobsupport.main.dto.ClientDto;
import com.jobsupport.main.entity.Client;
import com.jobsupport.main.repository.ClientRepository;
import com.jobsupport.main.service.ClientService;

@Service
public class UserServiceImpl implements ClientService{
	
	@Autowired
	private ClientRepository clientRepository;

	@Override
	public Client addClient(ClientDto clientDto) {
		Client client=Client.builder()
				.firstname(clientDto.getFirstname())
				.lastname(clientDto.getLastname())
				.phonenumber(clientDto.getPhonenumber())
				.email(clientDto.getEmail())
				.password(clientDto.getPassword())
				.country(clientDto.getCountry())
				.dob(clientDto.getDob())
				.gender(clientDto.getGender())
				.role(clientDto.getRole())
				.build();
		return  clientRepository.save(client);
	}

	@Override
	public Client login(String email, String password) throws Exception {
		 Client client = clientRepository.findByEmail(email).orElseThrow(()->  new Exception("Email not found..!!!"));
		 if(client.getPassword().equals(password)) {
			 return client;
		 }
		 else {
			 throw new Exception("Inavlid Credentials...!!!"); 
		 }
	}

}
