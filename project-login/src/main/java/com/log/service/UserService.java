package com.log.service;

import com.log.entity.User;

public interface UserService 
{
	public User createUser(User user);
	public boolean checkUsername(String username);
}
