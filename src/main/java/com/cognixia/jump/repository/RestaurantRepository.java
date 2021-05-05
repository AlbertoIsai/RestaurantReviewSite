package com.cognixia.jump.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognixia.jump.model.Restaurant;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
	
	
	Restaurant findRestaurauntByRestaurantName(String restaurantName);
	
	List<Restaurant> findAll();
	
	List<Restaurant> findRestaurauntsByCity(String city);
	
	@Query("select restaurantName, description, city from Restaurant where restaurantId = ?1")
	Restaurant findRestaurauntById(Integer rid);
	
	
	
}
