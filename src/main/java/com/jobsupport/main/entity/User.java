package com.jobsupport.main.entity;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class User implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	@Id
	private String email;
	
	private String firstname;

	private String lastname;
	
	private String fullname;

	private long phonenumber;

	private String password;

	private String country;
	
	private LocalDate dob;
	
	private String gender;
	
	private String role;

	private String description;

	private String domain;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<Authority> authorities = new HashSet<>();
			 authorities.add(new Authority("ROLE_"+this.role));
	        return authorities;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
