package com.cognixia.jump.controller;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.UserRepository;

@CrossOrigin
@RestController
public class UserController 
{
	@Autowired
	UserRepository userRepo;
		
	
	//-------------------GET METHODS-------------------
    @GetMapping(value = "/getuser")
    @CrossOrigin
    public User currentUserNameSimple(HttpServletRequest request) {
        Principal principal = request.getUserPrincipal();
        return userRepo.findUsersByUsername(principal.getName());
    }
    
	@GetMapping(value="/user/review/{reviewId}")
	public String findUserByReview(@PathVariable Integer reviewId) {
		return userRepo.findUserNameByReview(reviewId);
	}
	
	
	@GetMapping(value="/user/name")
	public User findByUsername(String username)
	{
		return userRepo.findUsersByUsername(username);
	}
	
	@GetMapping("/user/id/{id}")
	public Optional<User> findUserById(@PathVariable String id)
	{
		 return userRepo.findById(Integer.parseInt(id));
	}
	
	//take in user and check to make sure password matches. if it does, return User
	@GetMapping(value="/user/validation")
	public boolean isValid(User user) {
		if (user.getUsername().equals(userRepo.findUserByPassword(user.getPassword()).getUsername())) {
			return true;
		}
		return false;
	}
	//
	
	//take in user, return whether or not its an admin
	@GetMapping(value="/user/admin/")
	public boolean isAdmin(String userName) {
		if(userRepo.isAdmin(userName)) {
			return true;
		}
		return false;
	}
	
	@GetMapping("/user/admins")
	public List<User> findUserAdmins()
	{
		return userRepo.findUsersByAdmin(true);	
	}
	
//----------------------POST METHODS----------------	
	
	@PostMapping(value="/user")
	public void addReview(@RequestBody User user) {
		userRepo.save(user);
	}

	
//-----------------UPDATE METHODS-----------------
	@PutMapping(value="/user")
	public User updateUser(User user)
	{
		//adds new info into a current user ID from json
		return userRepo.save(user);		
	}
}