package com.jobsupport.main.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.jobsupport.main.entity.User;
import com.jobsupport.main.repository.UserRepository;

@Service
public class JwtServiceImplementation implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	public JwtResponse createJwtToken(JwtRequest jwtRequest) throws Exception {
		String email = jwtRequest.getEmail();
		String password = jwtRequest.getPassword();
		authenticate(email, password);
		
		UserDetails userDetails = loadUserByUsername(email);
		String generateToken = jwtUtil.generateToken(userDetails);
		
		return new JwtResponse(generateToken);
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = userRepository.findByEmail(email).get();
		if(user!=null) {
			return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(),user.getAuthorities());
		}
		else {
			throw new UsernameNotFoundException("User Not found with email :" + user);
		}
	}
	
	private void authenticate(String email, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
