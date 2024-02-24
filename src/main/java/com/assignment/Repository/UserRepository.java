package com.assignment.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assignment.Model.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, String>{
	
	public Optional<Users> findByEmail(String email);

}
