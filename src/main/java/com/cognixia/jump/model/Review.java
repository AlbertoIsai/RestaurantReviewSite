package com.cognixia.jump.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Table(name="review")
@Entity
public class Review {

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

	@Column(name="reviewBody")
	private String reviewBody;
	
	@Column(name="rating")
	private Integer stars;
		
	public Review(Restaurant restaurant, User user, Integer stars) {
		super();
		this.id = new IdClass(restaurant.getRestaurantId(), user.getUserId());
		this.restaurant = restaurant;
		this.user = user;
		this.stars = stars;
	}
	
	public Review(Restaurant restaurant, User user) {
		super();
		this.id = new IdClass(restaurant.getRestaurantId(), user.getUserId());
		this.restaurant = restaurant;
		this.user = user;
		this.stars = 5;
		this.reviewBody = "Perfect";
	}
	
	

	public Review() {
		super();
	}

	public IdClass getId() {
		return id;
	}

	public void setId(IdClass id) {
		this.id = id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getReviewBody() {
		return reviewBody;
	}

	public void setReviewBody(String reviewBody) {
		this.reviewBody = reviewBody;
	}

	public Integer getStars() {
		return stars;
	}

	public void setStars(Integer stars) {
		this.stars = stars;
	}

	@Override
	public String toString() {
		return "Review [id=" + id + ", restaurant=" + restaurant + ", user=" + user + ", reviewBody=" + reviewBody
				+ ", stars=" + stars + "]";
	}

	
	
	
}
