package com.revature.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;

import com.revature.util.ConnectionUtil;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mindrot.jbcrypt.BCrypt;

import com.revature.dao.UserDAO;
import com.revature.dao.UserDAOI;
import com.revature.models.User;
import com.revature.services.UserService;

public class UserServiceTest {

	UserService userTest = new UserService();
	private static int workload = 12;
	private Connection conn = ConnectionUtil.getConnection();
	private UserDAOI ud = new UserDAO();
	private User um = new User(); 
	private User um2 = new User(); 
		
	// checks to see if hash password is working 
	@Test
	public void checkHash() {
		String password_plaintext = "password" ; 
		String stored_hash =hashPassword(password_plaintext); 
		 assertNotEquals(password_plaintext,stored_hash, false); 	
	}
	
	// checks to see password is not null 
	@Test 
	public void checkPasswordNotNull() {
		String password_plaintext = "password"; 
		assertNotNull(password_plaintext); 
	}
	// checks to see object is not null
	@Test 
	public void userExists() {
	 User exampleUser = new User();
	 assertNotNull(exampleUser);
	}
	
	
	//hashes user input password
	public static String hashPassword(String password) {
		String salt = BCrypt.gensalt(workload);
		String hashed_password = BCrypt.hashpw(password, salt);

		return(hashed_password);
	}
	
   // testing insert and select on user dao  ****note revisit this test
/*	@Test
	public void testUserDatabase() throws Exception {

	  Connection connection = ConnectionUtil.getConnection(); 
	  connection.setAutoCommit(false);    

	 UserDAO testDAO = new UserDAO();
	
     um.setFirstName("Pranav");
     um.setLastName("Udayakumar");
	 um.setPassword("password");
	 um.setRole(1);
	 um.setUsername("username1000");
	 um.setEmail("test100@hotmail.com");
	 
	 um2.setFirstName("Jane");
     um2.setLastName("Doe");
	 um2.setPassword("password");
	 um2.setRole(2);
	 um2.setUsername("username1001");
	 um2.setEmail("test102@hotmail.com");
 
	  try{
		  
	    
	    testDAO.addUser(um);
	    testDAO.addUser(um2); 
	    testDAO.getUserbyId(1);
	    testDAO.getUserbyId(19);

	    assertEquals(um, testDAO.getUserbyId(1));
	    assertEquals("um2", testDAO.getUserbyId(18));

	    
	  } finally {
	    connection.rollback();
	    connection.close();
	  }  
	
	}*/

}
