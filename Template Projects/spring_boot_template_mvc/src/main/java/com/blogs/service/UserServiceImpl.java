package com.blogs.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blogs.custom_exception.InvalidCredentialException;
import com.blogs.entities.User;
import com.blogs.repository.UserRepository;

@Service// mandatory class level ann to tell sc
//following is spring bean containing BL
@Transactional
public class UserServiceImpl implements UserService {
//dependency
	@Autowired
	private UserRepository userRepository;
	@Override
	public User signInUser(String email, String pwd) {
		// TODO Auto-generated method stub
		Optional<User>optional=
				userRepository.findByEmailAndPassword(email, pwd);
		return optional.orElseThrow(()->new InvalidCredentialException(" Invalid Email and password"));
	}

}
