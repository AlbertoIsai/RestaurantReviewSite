package com.cognixia.jump.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cognixia.jump.model.Restaurant;

@Component
public class RestaurantServiceFallback implements RestaurantService{

	@Override
	public List<Restaurant> findAllRestaurants() {

		List<Restaurant> defaultList = new ArrayList<>();
		defaultList.add(new Restaurant(000, "N/A", "N/A", "N/A", "N/A", "No Description"));
        return defaultList;	}

	@Override
	public Restaurant findById(Integer restaurantId) {
		return null;
	}

	@Override
	public Restaurant update(Integer restaurantId, Restaurant restaurant) {
		return null;
	}

	@Override
	public void delete(Integer restaurantId) {
		
	}

	@Override
	public Restaurant update(Restaurant restaurant) {
		return null;
	}

}
