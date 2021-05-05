package com.cognixia.jump.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cognixia.jump.model.Restaurant;

@Service
public interface RestaurantService {

	@GetMapping(value = "/restaurant")
	List<Restaurant> findAllRestaurants();
	
	@GetMapping(value="/restaurant/{restaurantId}")
	Restaurant findById(@PathVariable("restaurantId") Integer restaurantId);
	
	@PutMapping(value = "/restaurant/{restaurantId}")
	Restaurant update(@PathVariable("restaurantId") Integer restaurantId,@RequestBody Restaurant restaurant);

	@DeleteMapping(value = "/restaurant/{restaurantId}")
	void delete(@PathVariable("restaurantId") Integer restaurantId);

	@PostMapping(value = "/account")
	Restaurant update(@RequestBody Restaurant restaurant);
}
