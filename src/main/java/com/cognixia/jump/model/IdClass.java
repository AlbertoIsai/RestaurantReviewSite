package com.cognixia.jump.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class IdClass implements Serializable{


	private static final long serialVersionUID = 1L;

	@Column(name="userId")
	private Integer userId;
	
	@Column(name="restaurantId")
	private Integer restaurantId;

	
	public IdClass() {
		super();
	}


	public IdClass(Integer userId, Integer restaurantId) {
		super();
		this.userId = userId;
		this.restaurantId = restaurantId;
	}
	
}
