package com.website.tmdt.services.ITF;

import org.springframework.http.ResponseEntity;

import com.website.tmdt.model.User;
import com.website.tmdt.model.entity.ResponseObject;

public interface LoginServiceITF {
	public ResponseEntity<ResponseObject> checkLogin (String username, String password);
	public ResponseEntity<ResponseObject> signup_account (User new_user) ;
}
