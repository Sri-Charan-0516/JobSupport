package com.jobsupport.main.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.jobsupport.main.entity.Client;

@Repository
public interface ClientRepository extends JpaRepository<Client, String>{

	@Query(value="select c from Client c where c.email=?1")
	Optional<Client> findByEmail(String email);
}
