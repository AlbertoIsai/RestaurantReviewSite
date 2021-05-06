package com.cognixia.jump.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.cognixia.jump.model.Restaurant;
import com.cognixia.jump.repository.RestaurantRepository;

@RestController
public class RestaurantController {
	
	@Autowired
	RestaurantRepository restaurantRepository;
	
	@GetMapping(value = "/restaurant")
	public Iterable<Restaurant> all() {
		List<Restaurant> restaurants = restaurantRepository.findAll();
		return restaurants;
	}
	
	@GetMapping(value = "/restaurant/{customerId}")
	public Restaurant findByRestauranttId(@PathVariable Integer restaurantId) {
		Restaurant restaurant = restaurantRepository.findRestaurauntById(restaurantId);
		return restaurant;
	}
	
	
}