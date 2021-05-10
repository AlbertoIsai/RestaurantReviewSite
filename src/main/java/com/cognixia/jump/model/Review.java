package com.cognixia.jump.model;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Table(name = "review")
@Entity
public class Review {

//	//in the project, this would be the "Reviews/Posts class with more fields"
//	@EmbeddedId
//	private IdClass id;
	@Id // Pk
	@Column(name = "review_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer reviewId;

//	@ManyToOne
//	@MapsId("restaurantId")
//	@JoinColumn(name="restaurant_Id")
	@Column(name = "restaurant_Id")
	private Integer restaurantId;

//	@ManyToOne
//	@MapsId("userId")
//	@JoinColumn(name="user_Id")
	@Column(name = "user_Id")
	private Integer userId;

	@Column(name = "reviewBody")
	private String reviewBody;

	@Column(name = "rating")
	private Integer stars;

	public Review(Integer restaurantId, Integer userId, String reviewBody, Integer stars) {
		super();
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.reviewBody = reviewBody;
		this.stars = stars;
	}

	public Review(Integer restaurantId, Integer userId, Integer stars) {
		super();
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.stars = stars;
		this.reviewBody = " ";
	}

	public Review(Integer restaurantId, Integer userId) {
		super();
		this.restaurantId = restaurantId;
		this.userId = userId;
		this.stars = 5;
		this.reviewBody = "Perfect";
	}

	public Review() {
		super();
	}

	public Integer getReviewId() {
		return reviewId;
	}

	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}

	public Integer getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Integer restaurantId) {
		this.restaurantId = restaurantId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
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
		return "Review [reviewId=" + reviewId + ", restaurantId=" + restaurantId + ", userId=" + userId
				+ ", reviewBody=" + reviewBody + ", stars=" + stars + "]";
	}

}
