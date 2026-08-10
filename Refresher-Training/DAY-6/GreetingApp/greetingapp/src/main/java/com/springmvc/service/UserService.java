package com.springmvc.service;

import java.util.List;

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
	
	public User getUserById(Long id) {
		return userDAO.getUserById(id);
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
	  
	  public boolean updateUser(User user) {
		    return userDAO.UpdateUser(user);
		}
	  
	  public List<User> getAllUsers(){
		  return userDAO.getAllUsers();	
		  }
	 
	  public boolean deleteUser(Long id) {
		    return userDAO.deleteUser(id);
		}

}
