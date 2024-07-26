package com.website.tmdt.services;

import com.website.tmdt.model.User;
import com.website.tmdt.model.entity.LoginRequest;
import com.website.tmdt.model.entity.ResponseObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.website.tmdt.repository.UserRepository;
import com.website.tmdt.services.ITF.LoginServiceITF;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginService implements LoginServiceITF {
	@Autowired
	private UserRepository userRepository;

	public ResponseEntity<ResponseObject> signup_account (User new_user) {
		Optional<User> NewUser = userRepository.findByEmail(new_user.getEmail());
		if(NewUser.isEmpty()){
			userRepository.save(new_user);
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject("Succes", "Create User Success", new_user)
			);
		}
        else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(
					new ResponseObject("Failed", "Cannot create user, because email "+new_user.getEmail()+"has been exits",""));
		}	
	}
	
	@Override
	public ResponseEntity<ResponseObject> checkLogin(String username, String password) {
		Optional<LoginRequest> check = userRepository.findByUsernameAndPassword(username, password);
		if(check.isPresent()){
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject("Success","Login success with username:"+username,""));
		}
		else { 
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					new ResponseObject("Success","Login failed with username:"+username,""));
		}
	}

}
