package com.jobsupport.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobsupport.main.dto.UserDto;
import com.jobsupport.main.entity.User;
import com.jobsupport.main.repository.UserRepository;
import com.jobsupport.main.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public String addClient(UserDto userDto) {
		User user=User.builder()
				.firstname(userDto.getFirstname())
				.lastname(userDto.getLastname())
				.phonenumber(userDto.getPhonenumber())
				.email(userDto.getEmail())
				.password(userDto.getPassword())
				.country(userDto.getCountry())
				.dob(userDto.getDob())
				.gender(userDto.getGender())
				.build();
		 userRepository.save(user);
		 return "User Registered Succesfull..!!";
	}

}
