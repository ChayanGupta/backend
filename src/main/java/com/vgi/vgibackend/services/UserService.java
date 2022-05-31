package com.vgi.vgibackend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vgi.vgibackend.entities.User;
import com.vgi.vgibackend.repositories.UserRepository;

@Service
public class UserService {
	@Autowired UserRepository repository;
	
	public Boolean checkUserExists(String email) {
		User findByEmail = repository.findByEmail(email);
		if(findByEmail==null)
			return false;
		return true;
	}
	
	public User saveUser(User user) {
		return repository.save(user);
	}
	
	public User loginUser(User user) {
		return repository.findByEmailAndPassword(user.getEmail(), user.getPassword());
	}
}