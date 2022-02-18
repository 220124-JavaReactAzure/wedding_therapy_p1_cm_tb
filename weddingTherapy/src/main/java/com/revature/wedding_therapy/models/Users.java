package com.revature.wedding_therapy.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	
	@Id
	@Column(name = "user_id")
	private int user_id;

	@Column(name = "wedding_roll")
	private String wedding_roll;

	@Column(name = "firstname")
	private String firstname;

	@Column(name = "lastname")
	private String lastname;

	@Column(name = "email")
	private String email;

	@Column(name = "username")
	private String username;

	@Column(name = "password")
	private String password;

	@Column(name = "meal_id")
	private int meal_id;

	@Column(name = "plus_one")
	private boolean plus_one;
	
	@Column(name = "plus_one_meal_id")
	private int plus_one_meal_id;

	@Column(name = "betrothed")
	private boolean betrothed;

	@Column(name = "wedding_id")
	private int wedding_id;

	
	// CONSTRUCTORS
	// Default Constructor
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Full-Arg Constructor
	public Users(int user_id, String wedding_roll, String firstname, String lastname, String email, String username,
			String password, int meal_id, boolean plus_one, int plus_one_meal_id, boolean betrothed, int wedding_id) {
		super();
		this.user_id = user_id;
		this.wedding_roll = wedding_roll;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.password = password;
		this.meal_id = meal_id;
		this.plus_one = plus_one;
		this.plus_one_meal_id = plus_one_meal_id;
		this.betrothed = betrothed;
		this.wedding_id = wedding_id;
	}

	
	// GETTERS & SETTERS
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getWedding_roll() {
		return wedding_roll;
	}

	public void setWedding_roll(String wedding_roll) {
		this.wedding_roll = wedding_roll;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public int getMeal_id() {
		return meal_id;
	}

	public void setMeal_id(int meal_id) {
		this.meal_id = meal_id;
	}

	public boolean isPlus_one() {
		return plus_one;
	}

	public void setPlus_one(boolean plus_one) {
		this.plus_one = plus_one;
	}

	public int getPlus_one_meal_id() {
		return plus_one_meal_id;
	}

	public void setPlus_one_meal_id(int plus_one_meal_id) {
		this.plus_one_meal_id = plus_one_meal_id;
	}

	public boolean isBetrothed() {
		return betrothed;
	}

	public void setBetrothed(boolean betrothed) {
		this.betrothed = betrothed;
	}

	public int getWedding_id() {
		return wedding_id;
	}

	public void setWedding_id(int wedding_id) {
		this.wedding_id = wedding_id;
	}

	
	// TOSTRING METHOD
	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", wedding_roll=" + wedding_roll + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", meal_id=" + meal_id + ", plus_one=" + plus_one + ", plus_one_meal_id=" + plus_one_meal_id
				+ ", betrothed=" + betrothed + ", wedding_id=" + wedding_id + "]";
	}

	
	// HASHCODE METHOD
	@Override
	public int hashCode() {
		return Objects.hash(betrothed, email, firstname, lastname, meal_id, password, plus_one, plus_one_meal_id,
				user_id, username, wedding_id, wedding_roll);
	}

	//EQUALS METHOD
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return betrothed == other.betrothed && Objects.equals(email, other.email)
				&& Objects.equals(firstname, other.firstname) && Objects.equals(lastname, other.lastname)
				&& meal_id == other.meal_id && Objects.equals(password, other.password) && plus_one == other.plus_one
				&& plus_one_meal_id == other.plus_one_meal_id && user_id == other.user_id
				&& Objects.equals(username, other.username) && wedding_id == other.wedding_id
				&& Objects.equals(wedding_roll, other.wedding_roll);
	}
	
	
	
	
}
