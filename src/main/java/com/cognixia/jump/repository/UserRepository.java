package com.cognixia.jump.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.User;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	List<User> findAll();
	User findUsersByUsername(String username);
	
	//Boolean isAdmin();
}
