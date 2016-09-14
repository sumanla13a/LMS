package edu.mum.cs.cs401.controller;

import java.util.Collection;

import edu.mum.cs.cs401.dataaccess.DataAccess;
import edu.mum.cs.cs401.dataaccess.DataAccessImpl;
import edu.mum.cs.cs401.entity.User;

public class UserController {
	private static UserController instance = new UserController();
	
	private DataAccess<String, User> dataAccess = new DataAccessImpl<String, User>();
	
	private UserController() {}
	
	public static UserController getInstance() {return instance;}
	
	public User addNew(User user) {
		return dataAccess.add(user.getUserName(), user);
	}
	
	public User getById(String id) {
		return dataAccess.get(id);
	}
	
	public Collection<User> getAll() {
		return dataAccess.get();
	}
}
