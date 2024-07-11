package com.blogs.custom_exception;

public class InvalidCredentialException extends RuntimeException {
	
	public InvalidCredentialException(String msg) {
		
		super(msg);
	}

}
