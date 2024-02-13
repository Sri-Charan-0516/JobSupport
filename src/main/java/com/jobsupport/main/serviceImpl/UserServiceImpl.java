package com.jobsupport.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.jobsupport.main.dto.ClientDto;
import com.jobsupport.main.entity.User;
import com.jobsupport.main.exceptions.InvalidUserIdException;
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

	@Override
	public User updateClient(String email, User user) throws InvalidUserIdException {
		User user2 = userRepository.findById(email).orElseThrow(()-> new InvalidUserIdException("Email doesnot exists with :"+email));
		user2.setFirstname(user.getFirstname());
		user2.setLastname(user.getLastname());
		user2.setPhonenumber(user.getPhonenumber());
		user2.setDescription(user.getDescription());
		
		return userRepository.save(user2);
	}

	@Override
	public User getClientDetails(String mail) throws InvalidUserIdException {
		User user = userRepository.findById(mail).orElseThrow(()-> new InvalidUserIdException("Email Doesnot exists...!!!"));
		return user;
	}

}
