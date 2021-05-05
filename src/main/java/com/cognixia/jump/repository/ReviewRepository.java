package com.cognixia.jump.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognixia.jump.model.Restaurant;
import com.cognixia.jump.model.Review;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

	List<Review> findAll();

	@Query(value = "SELECT * FROM review WHERE user_id = (select user_id from user where user_name = ?1", nativeQuery = true)
	List<Review> findReviewsByUserName(String userName);
	
	@Query(value = "SELECT * FROM review WHERE restaurant_id = (select restaurant_id from user where restaurant_name = ?1", nativeQuery = true)
	List<Review> findReviewsByRestaurantName(String restaurantName);
	
	
	
}
