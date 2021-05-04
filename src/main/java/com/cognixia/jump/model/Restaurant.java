package com.cognixia.jump.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Restaurant implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name="restaurantId")
	Integer restaurantId;

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

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + "]";
	}

	
	
}
