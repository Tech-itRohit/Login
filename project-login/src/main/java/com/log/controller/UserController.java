package com.log.controller;
import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.log.entity.User;
import com.log.repository.UserRepository;





@RestController
@RequestMapping("/user/")
public class UserController 
{
	@Autowired
	private UserRepository userRepo;
	@ModelAttribute
	private void userDetails(Model m, Principal p)
	{
		String username =p.getName();
		User user=userRepo.findByUsername(username);
		
		m.addAttribute("user",user);
	}
	
//	@GetMapping("/getuserbyid")
//	public User getUser()
//	{
//		System.out.println("getting users");
//		return userRepo.findByEmail(null);
//	}
	
}

