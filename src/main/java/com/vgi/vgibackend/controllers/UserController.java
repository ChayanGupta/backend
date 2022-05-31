package com.vgi.vgibackend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vgi.vgibackend.entities.User;
import com.vgi.vgibackend.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

	@Autowired UserService service;
	
	@PostMapping("/register")
	public User register(@RequestBody User user) {
		if(service.checkUserExists(user.getEmail()))
			return new User();
		return service.saveUser(user);
	}
	
	@PostMapping("/login")
	public User login(@RequestBody User user) {
		return service.loginUser(user);
	}
}