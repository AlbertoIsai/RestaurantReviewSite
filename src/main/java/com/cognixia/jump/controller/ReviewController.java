package com.cognixia.jump.controller;

import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Restaurant;
import com.cognixia.jump.model.Review;
import com.cognixia.jump.model.User;
import com.cognixia.jump.repository.RestaurantRepository;
import com.cognixia.jump.repository.ReviewRepository;
import com.cognixia.jump.repository.UserRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@RestController
public class ReviewController {

	@Autowired
	ReviewRepository repo;
	
	@Autowired
	RestaurantRepository restaurantRepo;
	
	@Autowired
	UserRepository userRepo;
	
	//-----------------GET METHODS------------------------
	
	@GetMapping(value="/getreview/{userName}")
	public List<Review> findReviewsByUser(@PathVariable String userName){
		return repo.findReviewsByUserName(userName);
	}
	
	@GetMapping(value="/getreview/{restaurantName}")
	public List<Review> findReviewsByRestaurant(@PathVariable String restaurantName){
		return repo.findReviewsByRestaurantName(restaurantName);
	}
	
	@GetMapping(value="/getreview/avg/{restaurantName}")
	public Double findStarAverage(@PathVariable String restaurantName) {
		return repo.findAverageStars(restaurantName);
	}
	
	
	//-----------------POST METHOD------------------------
	@PostMapping(value="/review")
	public @ResponseBody String addReview(@RequestBody Review review) {
		int userId = review.getUserId();
		int restaurantId = review.getRestaurantId();
		if(repo.findReviewByUserAndRestaurant(restaurantId, userId) != null) {
			return "This user has already reviewed this restaurant";
		} else {
			repo.save(review);
			return "Successfully added your review";
		}
		
	}
	

	
	//---------------- UPDATE METHODS---------------------
	
	@PutMapping(value = "/review")
	public void update(@RequestBody Review review) {
		repo.save(review);
	}
	
	@PostMapping(value = "/samplereview")
	public void update() {

		repo.save(new Review(1,1));
	}
	
	
}
