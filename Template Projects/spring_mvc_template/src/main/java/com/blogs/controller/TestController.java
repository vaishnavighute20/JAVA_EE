package com.blogs.controller;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // mandatory class level annotation to tell sc
public class TestController {
	public TestController() {
		System.out.println("in constructor of "+ getClass());
	}
		//add init method
		@PostConstruct
		
		public void myinit() {
			System.out.println("in  init of "+ getClass());
		}
		//
		
		@RequestMapping("/test")
		public String testMe() {
			System.out.println("in  testMe "+ getClass());
         return "/display";//LVN ,handler returns LVN --D.S
         // -->V.R -->prefix+LVN+suffix---AVN -->D.S
        // AVN -/ WEB-INF/views/disply.jsp
		}
	}
	
	


