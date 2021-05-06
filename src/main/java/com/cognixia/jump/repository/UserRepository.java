package com.cognixia.jump.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.User;

import java.util.List;
@Repository
public interface UserRepository extends JpaRepository<User,Integer>{
	
	List<User> findAll();
	User findUsersByUsername(String userName);
	
	List<User> findUsersByAdmin(boolean admin);

	@Query(value = "SELECT admin FROM user WHERE userName = ?1", nativeQuery = true)
	boolean isAdmin(String userName);
}
