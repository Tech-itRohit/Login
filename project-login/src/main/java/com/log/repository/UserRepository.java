package com.log.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.log.entity.User;



public interface UserRepository extends JpaRepository<User, String> 
{
	public boolean existsByUsername(String username);
	
	public User findByUsername(String username);
	

	
	
}