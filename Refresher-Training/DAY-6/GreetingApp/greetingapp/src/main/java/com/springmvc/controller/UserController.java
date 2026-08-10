package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.springmvc.exception.UserAlreadyExistsException;
import com.springmvc.model.User;
import com.springmvc.service.UserService;

import org.springframework.ui.Model;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService  = userService;
	}
	
	
	@GetMapping("/register")
	public String showRegisterPage() {
		return "register";
	}
	
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	
	@PostMapping("/register")
	public String registerUser(HttpServletRequest request , Model model ) {
		
		 User user = new User();
		 user.setName(request.getParameter("name"));
		 user.setEmail( request.getParameter("email")); 
		 user.setPassword(request.getParameter("password"));
		 
		 try {
			 userService.registerUser(user);
			 model.addAttribute("message", "Registration successfull Please Login");
			 return "login";
		 }catch(UserAlreadyExistsException e) {
			model.addAttribute("error", e.getMessage());
			return "register";
		 }
	}
	
	@PostMapping("/login")
	public String loginUser(@ModelAttribute User user, Model model) {
		User loggedInUser = userService.loginUser(user.getEmail(),user.getPassword());
		
		if(loggedInUser != null) {
			model.addAttribute("name", loggedInUser.getName());
			return "greeting";
			}else {
				model.addAttribute("error", "Invalid email or password");
				return "login";
			}	
	}
	
	
	
}
