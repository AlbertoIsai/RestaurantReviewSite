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

	//TODO FIX QUERRIES
	@Query(value = "SELECT admin FROM user WHERE userName = :userName", nativeQuery = true)
	boolean isAdmin(String userName);
	
	User findUserByPassword(String password);
	
	@Query(value = "SELECT user_name FROM user WHERE user_id = (select user_id from review where review_id = :reviewId)", nativeQuery = true)
	String findUserNameByReview(Integer reviewId);

	
}
