package com.blogs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
	public AdminController() {
		System.out.println("in constructor of "+getClass());
		
	}
	//add request handling method to forward admin to the home page
	//URL - http://host:port/spring_boot/admin/home
	//method : GET 
	@GetMapping("/home")
	public String adminHome() {
System.out.println("in admin home");
return "/admin/home";
	}
}
