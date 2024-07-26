package com.website.tmdt.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.website.tmdt.model.User;
import com.website.tmdt.model.entity.CustomUserDetails;
import com.website.tmdt.model.entity.ResponseObject;
import com.website.tmdt.repository.UserRepository;
import com.website.tmdt.services.ITF.UserServiceITF;

@Service
public class UserServices implements UserServiceITF{
	@Autowired
	private UserRepository userRepository;
	
	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		User user = userRepository.findByUsername(username);
//		if(user ==null) {
//			throw new UsernameNotFoundException(username);
//		}
//		return new CustomUserDetails();
//	}

	
	public List<User> getAll(){
		List<User> list = userRepository.findAll();
		System.out.println(list);
		return list;
	}
	public ResponseEntity<ResponseObject> getUserById (int id) {
		Optional<User> foundUser = userRepository.findById(id);
		if(foundUser.isPresent()){
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject("Succes", "Found user success", foundUser)
			);
		}
        else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					new ResponseObject("Failed", "Cannot found user with id ="+id,""));
		}	
	
	}
	
	public ResponseEntity<ResponseObject> createUser (User new_user) {
		Optional<User> NewUser = userRepository.findByEmail(new_user.getEmail());
		if(NewUser.isEmpty()){
			userRepository.save(new_user);
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject("Succes", "Create User Success", NewUser)
			);
		}
        else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(
					new ResponseObject("Failed", "Cannot create user, because user with id"+new_user.getUser_id()+"has been exits",""));
		}	
	}
	
	public ResponseEntity<ResponseObject> updateUser (User user_update) {
		Optional<User> UpdateUser = userRepository.findById(user_update.getUser_id());
		if(UpdateUser.isPresent()){
			userRepository.save(user_update);
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject("Succes", "Update User Success", user_update)
			);
		}
        else {
			return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(
					new ResponseObject("Failed", "Failed to update",""));
		}	
	}
	
	public ResponseEntity<ResponseObject> deleteUserById (int id) {
		Optional<User> foundUser = userRepository.findById(id);
		if(foundUser.isPresent()){
			userRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body(
					new ResponseObject("Succes", "Delete user success", foundUser)
			);
		}
        else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
					new ResponseObject("Failed", "User with id ="+id+" not exits",""));
		}	
	
	
	}


	@Override
	public User findByUserName(String userName) {
		
		return userRepository.findByUsername(userName);
	}
	
}
