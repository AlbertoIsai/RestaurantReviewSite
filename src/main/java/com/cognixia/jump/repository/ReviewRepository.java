package com.cognixia.jump.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Restaurant;
import com.cognixia.jump.model.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {

	List<Review> findAll();

	//TODO FIX QUERRIES
	@Query(value = "SELECT * FROM review WHERE user_id = (select user_id from user where user_name = :userName", nativeQuery = true)
	List<Review> findReviewsByUserName(String userName);
	
	//TODO FIX QUERRIES
	@Query(value = "SELECT * FROM review WHERE restaurant_id = (select restaurant_id from restaurant where restaurant_name = :restaurantName", nativeQuery = true)
	List<Review> findReviewsByRestaurantName(String restaurantName);
	
	
	
}
