package com.jobsupport.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobsupport.main.dto.ClientDto;
import com.jobsupport.main.entity.User;
import com.jobsupport.main.repository.UserRepository;
import com.jobsupport.main.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public String getEncodedPassword(String password) {
		return passwordEncoder.encode(password);
	}

	@Override
	public User addClient(ClientDto clientDto) {
		User user=User.builder()
				.firstname(clientDto.getFirstname())
				.lastname(clientDto.getLastname())
				.fullname(clientDto.getFirstname()+" "+clientDto.getLastname())
				.phonenumber(clientDto.getPhonenumber())
				.email(clientDto.getEmail())
				.password(getEncodedPassword(clientDto.getPassword()))
				.country(clientDto.getCountry())
				.dob(clientDto.getDob())
				.gender(clientDto.getGender())
				.role(clientDto.getRole())
				.build();
		return  userRepository.save(user);
	}

}
