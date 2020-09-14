package com.revature.services;

import com.revature.models.User;
import com.revature.dao.UserDAOI;

import org.mindrot.jbcrypt.BCrypt;

import com.revature.dao.UserDAO;
import com.revature.models.User;

public class UserService {

	private UserDAOI ud = new UserDAO();

	// logs a user into the system
	public User login(User u) {
		boolean loginApproved = false;
		String hashedPassword, password;
		
		while (loginApproved == false) {
			 hashedPassword = u.getHashedPassword(); 
			 password = u.getPassword();
		 loginApproved = checkPassword(password,hashedPassword); 
				}
		return ud.findByUsernameAndPassword(u.getUsername(), u.getPassword());
	}

	// registers a new user to the system
	public int register(User u) {
		return ud.addUser(u);
	}

	// compares user input to hash
	public static boolean checkPassword(String password_plaintext, String stored_hash) {
		boolean password_verified = false;

		if (null == stored_hash || !stored_hash.startsWith("$2a$"))
			throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");

		password_verified = BCrypt.checkpw(password_plaintext, stored_hash);

		return (password_verified);
	}

}
