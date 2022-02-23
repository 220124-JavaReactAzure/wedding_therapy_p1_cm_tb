package com.revature.wedding_therapy.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "users")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")  // Helps stop serialization recursion
public class Users {
	
	@Id //Makes this field the table's Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) //Makes the PK serialized
	@Column(name = "user_id")
	private int user_id;

	//This field is not unique but cannot be null or blank
	@Column(name = "wedding_roll", nullable = false, columnDefinition = "VARCHAR CHECK (wedding_roll <> '')")
	private String wedding_roll;

	//this field must not be null, and not blank
	@Column(name = "firstname", nullable = false, columnDefinition = "VARCHAR CHECK (firstname <> '')")
	private String firstname;

	//this field must not be null, and not blank
	@Column(name = "lastname", nullable = false, columnDefinition = "VARCHAR CHECK (lastname <> '')")
	private String lastname;

	//this field must be unique, not null, and not blank
	@Column(name = "email", unique = true, nullable = false, columnDefinition = "VARCHAR CHECK (email <> '')")
	private String email;

	//this field must be unique, not null, and not blank
	@Column(name = "username", unique = true, nullable = false, columnDefinition = "VARCHAR CHECK (username <> '')")
	private String username;

	//this field must be unique, not null, and not blank
	@Column(name = "password", unique = true, nullable = false, columnDefinition = "VARCHAR CHECK (password <> '')")
	private String password;

	
	
	///////////// TODO: should this field be set up as a one to many or many to one relationship?
	@OneToMany (mappedBy="meal_id", fetch=FetchType.EAGER) 
	@JoinColumn(name = "meal_id")
	//@JsonIgnoreProperties(value = "meal_type")
	private int meal_id;
	/////////////// TODO: should this field be set up as a one to many or many to one relationship?
	
	
	//This field is not unique but cannot be null
	@Column(name = "plus_one", nullable = false)
	private boolean plus_one;
	
	
	
	/////////////// TODO: should this field be set up as a one to many or many to one relationship?
	@OneToMany (mappedBy="meal_id", fetch=FetchType.EAGER) 
	@JoinColumn(name = "plus_one_meal_id")
	private int plus_one_meal_id;
	/////////////// TODO: should this field be set up as a one to many or many to one relationship?
	
	

	//This field is not unique but cannot be null and only for bride or groom
	@Column(name = "betrothed", nullable = false)
	private boolean betrothed;

	
	
	/////////////// TODO: should this field be set up as a one to many or many to one relationship?
	@OneToMany (mappedBy="wedding_id", fetch=FetchType.EAGER) 
	@JoinColumn(name = "wedding_id")
	//@Column(name = "wedding_id")
	private int wedding_id;
	/////////////// TODO: should this field be set up as a one to many or many to one relationship?

	
	// CONSTRUCTORS
	// Default Constructor
	public Users() {
		super();
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
