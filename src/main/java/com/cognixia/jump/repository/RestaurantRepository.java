package com.cognixia.jump.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognixia.jump.model.Restaurant;

public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
	Restaurant findResturauntByName(String Rname);
	List<Restaurant> findAllResturaunts();
	List<Restaurant> findResturauntsByLocation(String location);
	Restaurant findResturauntById(Integer rid);
	
}
