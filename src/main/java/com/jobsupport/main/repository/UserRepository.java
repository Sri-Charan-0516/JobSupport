package com.jobsupport.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jobsupport.main.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, String>{

//	@Query(value="Select u from User u where u.email=?1")
//	Optional<User> findByEmail(String email);
}
