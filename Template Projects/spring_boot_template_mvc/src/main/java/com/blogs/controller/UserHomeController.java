package com.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller// spring bean containing request handling logic
public class UserHomeController {
	public UserHomeController() {
		System.out.println("in const of " +getClass());
	}
	//add a method to render login page
	@GetMapping("/")
	public String showLoginForm() {
		System.out.println("in show login form" +getClass());

		return "/users/login";// handler returning LVN -->dispacher servlet---view resolve
		//AVN:/WEB-INF/views/users/login.jsp
	}
	

}