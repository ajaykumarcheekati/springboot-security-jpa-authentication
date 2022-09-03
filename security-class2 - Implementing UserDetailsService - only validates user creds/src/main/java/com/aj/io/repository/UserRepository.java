package com.aj.io.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.aj.io.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	Optional<User> findUserByUsername(String username);

}
