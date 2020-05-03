package com.example.UserRepo.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="user_details")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int userId;
	
	@NotNull(message="First Name is compulsory")
	@Column(name = "first_name")
	private String firstName;

	@NotNull(message="Last Name is compulsory")
	@Column(name = "last_name")
	private String lastName;
	
	@NotNull(message="User Name is compulsory")
	@Column(name = "user_name")
	private String userName;

	@NotNull(message="Email is compulsory")
	@Email(message="Email is invalid")
	@Column(name = "email_id")
	private String emailId;
	
	@NotNull(message="Password is compulsory")
	@Length(min=5, message="Password should be atleast 5 characters")
	@Column(name = "password")
	private String password;
	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int id) {
		this.userId = id;
	}

	@JsonProperty("user_name")
	public String getUserName() {
		return userName;
	}

	@JsonProperty("user_name")
	public void setUserName(String name) {
		this.userName = name;
	}

	@JsonProperty("email_id")
	public String getEmailId() {
		return emailId;
	}

	@JsonProperty("email_id")
	public void setEmailId(String email) {
		this.emailId = email;
	}

	@JsonProperty("first_name")
	public String getFirstName() {
		return firstName;
	}

	@JsonProperty("first_name")
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@JsonProperty("last_name")
	public String getLastName() {
		return lastName;
	}

	@JsonProperty("last_name")
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@JsonProperty("password")
	public String getPassword() {
		return password;
	}

	@JsonProperty("password")
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
