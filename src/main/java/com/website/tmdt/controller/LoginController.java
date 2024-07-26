package com.website.tmdt.controller;

import com.website.tmdt.model.User;
import com.website.tmdt.model.entity.LoginRequest;
import com.website.tmdt.model.entity.ResponseObject;
import com.website.tmdt.services.LoginService;
import com.website.tmdt.services.UserServices;

import java.util.Optional;

import org.apache.catalina.startup.ClassLoaderFactory.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller

public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired 
    private UserServices userServices;

        
    	@GetMapping("/login")
    	public String login() {
    		return "login";
    	}
    	
  
        
        

    

    @PostMapping("/check")
     public ResponseEntity<ResponseObject> checkLogin(@RequestBody LoginRequest loginRequest){
    	String username = loginRequest.getUsername();
    	String password = loginRequest.getPassword();
    	return loginService.checkLogin(username,password);
       
    }
    
    @PostMapping("/signup")
     public ResponseEntity<ResponseObject> signup(@RequestBody User newuser){
    	return loginService.signup_account(newuser);
    }
}