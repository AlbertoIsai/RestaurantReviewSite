package com.cognixia.jump.controller;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import com.cognixia.jump.model.Restaurant;
import com.cognixia.jump.model.Review;
import com.cognixia.jump.repository.RestaurantRepository;

@RestController
@CrossOrigin
public class RestaurantController {
	
	
	@Autowired
	private RestaurantRepository repo;
	
	@GetMapping("/restaurants")
	public List<Restaurant> getAllRestaurants() {
		return repo.findAll();
	}
	
	@GetMapping("/restaurants/{id}")
	public Restaurant getRestaurantById(@PathVariable Integer id) {
		return repo.findById(id).get();
	}
	
	
	// PUT == UPDATE
	@PutMapping("/restaurants/{id}/edit")
	public ResponseEntity<Restaurant> updateRestaurant( @PathVariable Integer id, @RequestBody Restaurant restaurant) {
		
		Restaurant restaurantUpdated = repo.save(restaurant);
		
		return new ResponseEntity<Restaurant>(restaurantUpdated, HttpStatus.OK);
	}
	
	// Post == ADD/Insert
	@PostMapping("/restaurants/{id}/edit")
	public ResponseEntity<Restaurant> updateRestaurant( @RequestBody Restaurant restaurant) {
		
		Restaurant restaurantCreatedNew = repo.save(restaurant);
		
		// Because this is a NEW restaurant, it DOES NOT YET have an ID to path
		// After we created, we need to append the New ID to the URL path
		// for example, the new restaurant will be linked to /restaurants/newID
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(restaurantCreatedNew.getRestaurantId()).toUri();
		
		return ResponseEntity.created(uri).build();
		
	}
	
	
}