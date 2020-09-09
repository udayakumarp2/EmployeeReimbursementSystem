package com.revature.services;

import com.revature.models.User;
import com.revature.dao.UserDAOI;
import com.revature.dao.UserDAO;

public class UserService {

	private UserDAOI ud = new UserDAO();
	
	// logs a user into the system
	public User login(User u) {
		return ud.findByUsernameAndPassword(u.getUsername(), u.getPassword());
	}
	
	// registers a new user to the system
	public int register(User u) {
		return ud.addUser(u);
	}
}
