package com.emlakburada.entity;

public class User {
	private int id;
	private String userType;
	private String name;
	private String email;
	private String photo;
	private String bio;

	public User() {}

	public User(String userType, String name, String email) {
		this.userType = userType;
		this.name = name;
		this.email = email;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Override
	public String toString() {
		return "User [id = " + id
				+ ", usertype = " + userType
				+ ", name = " + name
				+ ", email = " + email
				+ ", photo = " + photo
				+ ", bio = " + bio + "]";
	}
}