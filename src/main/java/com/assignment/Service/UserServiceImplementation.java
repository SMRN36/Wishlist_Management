package com.assignment.Service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.assignment.Exception.UserException;
import com.assignment.Model.Users;
import com.assignment.Repository.UserRepository;

@Service
public class UserServiceImplementation implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	public Users registerUser(Users users) throws UserException {
		Optional<Users> optUser = userRepository.findByEmail(users.getEmail());
		if (optUser.isPresent()) {
	       throw new UserException("User exists with email " + users.getEmail());
		}
		users.setUserId(UUID.randomUUID().toString());
		users.setPassword(passwordEncoder.encode(users.getPassword()));
		return	userRepository.save(users);
	}
	
}
