package com.cognixia.jump.controller;
​
import java.util.ArrayList;
import java.util.List;
​
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
​
import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.UserRepository;
​
@RequestMapping("/api")
@RestController
public class UserController 
{
	@Autowired
	UserRepository userRepo;
	
	private static List<User> userDatabase = new ArrayList<>();
	private static int counter = 1;
	
​
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
	public User findUserById(@PathVariable String id)
	{
		// find a user by their user ID
		
		for(int i = 0; i < userDatabase.size(); i++)
		{
			if(userDatabase.get(i).getUserId() == Integer.parseInt( id))
			{
				return userDatabase.get(i);
			}
		}
		return new User();
	}
	
	@GetMapping("/user/admins")
	public List<User> findUserAdmins()
	{
		// return all admin users
		
	List<User> admins = null;
		for(int i = 0; i < userDatabase.size(); i++)
		{
			if(userDatabase.get(i).getAdmin() == true)
			{
				admins.add(userDatabase.get(i));
			}
		}
		return admins;
	}
	
	@PostMapping("/user")
	public User createNewUser(Integer userId, Boolean admin, String username, String password)
	{
		// create new user from scratch
		
		User newUser = new User(counter++, admin, username, password);
		userDatabase.add(newUser);
		return newUser;
	}
	
	@PutMapping("user")
	public User updateUser(User user)
	{
		
		//adds new info into a current user ID from json
		
		String id = String.valueOf(user.getUserId());
		User updateUser = findUserById(id);
		
		if(updateUser.getUserId() != -1)
		{
			updateUser.setAdmin(user.getAdmin());
			updateUser.setUsername(user.getUsername());
			updateUser.setPassword(user.getPassword());
		}
		return updateUser;
		
	}
	
	
	
​
}