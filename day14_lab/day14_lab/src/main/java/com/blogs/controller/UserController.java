package com.blogs.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.ApiResponse;
import com.blogs.dto.AuthDTO;
import com.blogs.repository.UserRespDTO;
import com.blogs.service.UserService;

 
@RestController
@RequestMapping
public class UserController {
@Autowired
 private UserService userService;
	
	/*
	 * Authenticate User
	 * URL  http://host:port/users/signin
	 * method post   (only for security ,later for creating new resource JWT(json web token)
	 req- Auth dto (email,password)
	 resp- success(user response dto---fname,lname,dob,phone no,
	 failure --apiResp---err mesg
	 */
	@PostMapping("/signin")
	public ResponseEntity<?> userSignIn(@RequestBody AuthDTO dto){
		
		System.out.println("In sign in"+dto);
		try { 
			UserRespDTO respDto=userService.AuthenticateUser(dto);
		
			//success==>sc 200,resp body -user dto 
         return ResponseEntity.ok(respDto);
		}
	catch(RuntimeException e) {
		System.out.println(e);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
	}
		
	}
}
	
