package com.website.tmdt.services.ITF;

import java.util.List;

import com.website.tmdt.model.User;

public interface UserServiceITF {
	User findByUserName(String userName);

	List<User> getAll();
}
