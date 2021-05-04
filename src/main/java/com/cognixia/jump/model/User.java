package com.cognixia.jump.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Table(name="USERS")
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id								//Pk
	@Column(name="UserID")
	Integer userId;
	
	@Column(name="ADMIN")
	Boolean admin;
	
	@Column(name="USERNAME")
	String username;
	
	@Column(name="PASSWORD")
	String password;
	
	public User() {
		super();
	}
	
	public User(Integer userid,boolean admin,String username,String password) {
		this.userId=userid;
		this.admin=admin;
		this.username=username;
		this.password=password;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public Boolean getAdmin() {
		return admin;
	}
	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", admin=" + admin + ", username=" + username + ", password=" + password
				+ "]";
	}
	
	
	
}