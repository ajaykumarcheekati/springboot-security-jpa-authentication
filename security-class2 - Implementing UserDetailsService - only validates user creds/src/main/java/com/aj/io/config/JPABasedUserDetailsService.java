package com.aj.io.config;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.aj.io.entity.User;
import com.aj.io.repository.MyUserDetails;
import com.aj.io.repository.UserRepository;

public class JPABasedUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Optional<User> user = repo.findUserByUsername(username);
		
		User us = user.orElseThrow(() -> new UsernameNotFoundException("User not found"));
		
		return new MyUserDetails(us);
	}

}
