package com.blogs.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class HomeController {

	public HomeController() {
		System.out.println("in constructor of "+ getClass());

	}
	
	//add init method
			@PostConstruct //optional 
			
			public void myinit() {
				System.out.println("in  init of "+ getClass());
			}
			//
			
			@RequestMapping("/")
			public String testMe() {
				System.out.println("in  testMe "+ getClass());
	         return "/index";//LVN ,handler returns LVN --D.S
	         
			}
		}
