package com.cognixia.jump.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Review;
import com.cognixia.jump.repository.ReviewRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class ReviewController {

	@Autowired
	ReviewRepository repo;
	
	//-----------------GET METHODS------------------------
	
	@GetMapping(value="/review/{userName}")
	public List<Review> findReviewsByUser(@PathVariable String userName){
		return repo.findReviewsByUserName(userName);
	}
	
	@GetMapping(value="/review/{restaurantName}")
	public List<Review> findReviewsByRestaurant(@PathVariable String restaurantName){
		return repo.findReviewsByRestaurantName(restaurantName);
	}
	
	//-----------------POST METHOD------------------------
	@PostMapping(value="/review")
	public void addReview(@RequestBody Review review) {
		repo.save(review);
	}
	

	
	//---------------- UPDATE METHODS---------------------
	
	@PutMapping(value = "/review")
	public void update(@RequestBody Review review) {
		repo.save(review);
	}
	
	
	
}
