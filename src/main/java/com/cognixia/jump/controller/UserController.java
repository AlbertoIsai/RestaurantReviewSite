package com.cognixia.jump.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.UserRepository;

@RequestMapping("/api")
@RestController
public class UserController 
{
	@Autowired
	UserRepository userRepo;
		
	@GetMapping("/user")
	public List<User> getAllUsers()
	{
		// return all user
				
		return userRepo.findAll();
	}
	
	@GetMapping("/user/name")
	public User findByUsername(String username)
	{
		return userRepo.findUsersByUsername(username);
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> findUserById(@PathVariable String id)
	{
		 return userRepo.findById(Integer.parseInt(id));
	}
	//take in user, return whether or not its an admin
	@GetMapping("/user/admins")
	public List<User> findUserAdmins()
	{
		return userRepo.findUsersByAdmin(true);
		
	}
	
	@PostMapping(value="/user")
	public void addReview(@RequestBody User user) {
		userRepo.save(user);
	}
	
	@PutMapping(value="/user")
	public User updateUser(User user)
	{
		
		//adds new info into a current user ID from json
		return userRepo.save(user);
		
		
	}
}