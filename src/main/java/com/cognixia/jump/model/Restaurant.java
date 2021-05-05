package com.cognixia.jump.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Restaurant implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="restaurantId")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer restaurantId;

	@Column(name="restaurantName")
	String restaurantName;
	
	@Column(name="streetAddress")
	String streetAddress;
	
	@Column(name="city")
	String city;
	
	@Column(name="state")
	String state;
	
	@Column(name="description")
	String description;
	
	@Transient
	List<Review> reviews;
	
	
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}



	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Restaurant(Integer restaurantId) {
		super();
		this.restaurantId = restaurantId;
	}

	public Restaurant() {
		super();
	}
	public Restaurant(Integer restaurantId, String restaurantName, String streetAddress, String city, String state,
			String description) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		this.streetAddress = streetAddress;
		this.city = city;
		this.state = state;
		this.description = description;
	}	
	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + "]";
	}

	
}
