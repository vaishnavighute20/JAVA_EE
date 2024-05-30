package com.blogs.service;

import com.blogs.dto.AuthDTO;
import com.blogs.repository.UserRespDTO;

public interface UserService {
	
	UserRespDTO AuthenticateUser(AuthDTO dto);
}
