package com.blogs.service;

import com.blogs.entities.User;

public interface UserService {
// add a method for users signin
	User signInUser(String email,String pwd);
}
