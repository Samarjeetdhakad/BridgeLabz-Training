package com.springmvc.service;

import org.springframework.stereotype.Service;

import com.springmvc.dao.UserDAO;
import com.springmvc.exception.UserAlreadyExistsException;
import com.springmvc.model.User;

@Service
public class UserService {
	
	private final UserDAO userDAO;
	
	public UserService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}
	
	
	public void registerUser(User user) throws UserAlreadyExistsException{
		boolean exists = userDAO.UserExists(user.getEmail());
		
		if (exists) {
			throw new UserAlreadyExistsException("user already exists with this email");
		}
		
		userDAO.UserRegister(user);
	}
	
	
	  public User loginUser(String email , String password) {
		  return  userDAO.LoginUser(email,password );
	  }
	 

}
