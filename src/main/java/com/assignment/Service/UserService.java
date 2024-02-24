package com.assignment.Service;

import com.assignment.Exception.UserException;
import com.assignment.Model.Users;

public interface UserService {
	
	public Users registerUser(Users users) throws UserException;

}
