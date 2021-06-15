package com.mycompany.ucsa.service;

import org.springframework.security.core.userdetails.UserDetailsService;


import com.mycompany.ucsa.dto.UserRegistrationDto;
import com.mycompany.ucsa.entities.User;

public interface UserService extends UserDetailsService {
	
	User save (UserRegistrationDto registrationDto);

}
