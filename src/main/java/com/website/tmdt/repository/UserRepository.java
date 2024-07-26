package com.website.tmdt.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


import com.website.tmdt.model.User;
import com.website.tmdt.model.entity.LoginRequest;

public interface UserRepository extends JpaRepository<User, Integer>{
	Optional<LoginRequest> findByUsernameAndPassword(String username, String password);
	
	Optional<User> findByEmail(String email);
	
	User findByUsername(String username);

}




