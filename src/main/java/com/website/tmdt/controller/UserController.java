package com.website.tmdt.controller;

import com.website.tmdt.model.entity.ResponseObject;
import com.website.tmdt.repository.UserRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.website.tmdt.model.User;
import com.website.tmdt.services.UserServices;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;


@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserServices userServices;
	
	
	@GetMapping("/getAll")
	public List<User> getAll() {
		return userServices.getAll();
	}

	
//	@GetMapping("/getOne/{id}")
//	public User getOne(@PathVariable("id") int id) {
//		return userServices.getOne(id);
//	}

	@GetMapping("/getOne/{id}")
	public ResponseEntity<ResponseObject> getOne (@PathVariable int id){
		return userServices.getUserById(id);
    }



	@PostMapping("/create")
	public ResponseEntity<ResponseObject> createUser(@RequestBody User user) {
		return userServices.createUser(user);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResponseObject> deleteUser (@PathVariable int id){
		return userServices.deleteUserById(id);
	}
	
	@PutMapping("/update/")
	public ResponseEntity<ResponseObject> updateUser( @RequestBody User userUpdate) {
		return userServices.updateUser(userUpdate);
	}
}