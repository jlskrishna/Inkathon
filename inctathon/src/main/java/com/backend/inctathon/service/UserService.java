package com.backend.inctathon.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.backend.inctathon.model.User;
import com.backend.inctathon.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
