package com.log.controller;
import java.security.Principal;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.log.entity.User;
import com.log.repository.UserRepository;
import com.log.service.UserService;




@RestController
@RequestMapping("/home")
public class HomeController 
{
	@Autowired
	private UserService  userService;
	
	@Autowired
	private UserRepository userRepo;
	
//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;
	
	@ModelAttribute
	private void userDetails(Model m, Principal p)
	{
		if(p!=null)
		{
			String username =p.getName();
			User user=userRepo.findByUsername(username);
			
			m.addAttribute("user",user);
		}
	}
	
	@GetMapping("/login")
	public String login()
	{
		return "signin";
	}
	@GetMapping("/register")
	public String register()
	{
		return "register";
	}
	@PostMapping("/createUser")
	public User createUser(@RequestBody User user, HttpSession session)
	{
		//System.out.println(user);
		boolean f=userService.checkUsername(user.getUsername());
		User user1=null;
		if(f)
		{
			session.setAttribute("msg","UserId already exists");
			System.out.println("User Id already exists");
		}
		else
		{
		user1	=userService.createUser(user);
			if(user1!=null)
			{
				session.setAttribute("msg","user created successfully");
				System.out.println("user created successfully");
			}
			else
			{
				session.setAttribute("msg","Something went wrong");
				System.out.println("Something went wrong");
			}
		}
		return user1;
	}
	@GetMapping("/loadForgotpassword")
	public String loadForgotPassword()
	{
		return"forgot_password";
	}
	
//	@GetMapping("/loadResetpassword")
//	public String loadResetPassword(@PathVariable int id, Model m)
//	{
//		m.addAttribute("id",id);
//		System.out.println(id);
//		return"reset_password";
//	}
	
//	@PostMapping("/forgotPassword")
//	public String forgotPassword( @RequestParam String email, HttpSession session )
//	{
//		User user=userRepo.findByEmail(email);
//		if(user!=null)
//		{
//			return "redirect:/loadResetpassword" +user.getId();
//		}
//		else 
//		{
//			session.setAttribute("msg","invalid email & mobile number");
//			return "forgot_password";
//		}
//
//	}
//
//	@PostMapping("/setPassword")
//	public String resetPassword(@RequestParam String password, @RequestParam String email, HttpSession session)
//	{
//		User user1=userRepo.findByEmail(email);
//		String encryptPsw= passwordEncoder.encode(password);
//		user1.setPassword(encryptPsw);
//		User updateUser=userRepo.save(user1);
//		if(updateUser!=null)
//		{
//			session.setAttribute("msg","Password Changed Successfully");
//		}
//		return"redirect:/loadForgotPassword";
//	}
}

