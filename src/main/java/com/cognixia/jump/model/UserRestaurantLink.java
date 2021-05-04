package com.cognixia.jump.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Table(name="user_restaurant_link")
@Entity
public class UserRestaurantLink {

	//in the project, this would be the "Reviews/Posts class with more fields"
	@EmbeddedId
	private IdClass id;
	
	@ManyToOne
	@MapsId("restaurantId")
	@JoinColumn(name="restaurant_Id")
	private Restaurant restaurant;
	
	@ManyToOne
	@MapsId("userId")
	@JoinColumn(name="user_Id")
	private User user;

	public UserRestaurantLink(IdClass id, Restaurant restaurant, User user) {
		super();
		this.id = new IdClass(restaurant.getRestaurantId(), user.getUserId());
		this.restaurant = restaurant;
		this.user = user;
	}

	
	
}
