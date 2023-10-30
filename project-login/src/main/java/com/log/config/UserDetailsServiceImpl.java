package com.log.config;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.log.entity.User;
import com.log.repository.UserRepository;




@Service
public class UserDetailsServiceImpl implements UserDetailsService
{

	@Autowired
	private UserRepository userRepo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException 
	{
		User user=userRepo.findByUsername(username);
		if(user!=null)
		{
			return new org.springframework.security.core.userdetails.User(
		            user.getUsername(),
		            user.getPassword(),
		            Collections.emptyList() // You can load user roles here
		        );
			
		}
		throw new UsernameNotFoundException("user not available");
	}
	
}	
    

