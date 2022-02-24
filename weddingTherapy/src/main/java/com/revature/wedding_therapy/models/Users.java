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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "users")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "user_id")  // Helps stop serialization recursion
public class Users {
	
	@Id //Makes this field the table's Primary Key
	//@GeneratedValue(strategy = GenerationType.IDENTITY) //Makes the PK serialized
	@Column(name = "user_id")
	private int user_id;

	//This field is not unique but cannot be null or blank
	//nullable = false, columnDefinition = "VARCHAR CHECK (wedding_roll <> '')")
//	@Column(name = "wedding_roll")
//	private String wedding_roll;

	//this field must not be null, and not blank
	//, nullable = false, columnDefinition = "VARCHAR CHECK (firstname <> '')")
	@Column(name = "firstname")
	private String firstname;

	//this field must not be null, and not blank
	//, nullable = false, columnDefinition = "VARCHAR CHECK (lastname <> '')")
	@Column(name = "lastname")
	private String lastname;

	//this field must be unique, not null, and not blank
	//, unique = true, nullable = false, columnDefinition = "VARCHAR CHECK (email <> '')")
	@Column(name = "email")
	private String email;

	//this field must be unique, not null, and not blank
	//, unique = true, nullable = false, columnDefinition = "VARCHAR CHECK (username <> '')")
//	@Column(name = "username")
//	private String username;

	//this field must be unique, not null, and not blank
	//, unique = true, nullable = false, columnDefinition = "VARCHAR CHECK (password <> '')")
//	@Column(name = "password")
//	private String password;

	
	
	///////////// TODO: should this field be set up as a one to many or many to one relationship?
	//@ManyToOne (fetch=FetchType.EAGER) 
	//@JoinColumn(name = "meal_type")
	//@JsonIgnoreProperties(value = "meal_type")
//	@Column(name = "meal_id")
//	private int meal_id;
	@OneToOne
	private Meal_Types meal;	
	/////////////// TODO: should this field be set up as a one to many or many to one relationship?
	
	
	//This field is not unique but cannot be null
	//, nullable = false)
	@Column(name = "plus_one")
	private boolean plus_one;
	
	
	
	/////////////// TODO: should this field be set up as a one to many or many to one relationship?
	//@ManyToOne (fetch=FetchType.EAGER)
	//@JoinColumn(name = "plus_one_meal_type")
//	@Column(name = "plus_one_meal_id")
//	private int plus_one_meal_id;
	@OneToOne
	private Meal_Types plus_one_meal;	
	/////////////// TODO: should this field be set up as a one to many or many to one relationship?
	
	
	/////////////// TODO: should this field be set up as a one to many or many to one relationship?
	//@OneToOne (mappedBy="wedding_id", fetch=FetchType.EAGER) 
	//@JoinColumn(name = "wedding_id")
	@OneToOne
	private Weddings wedding;
	/////////////// TODO: should this field be set up as a one to many or many to one relationship?



	//This field is not unique but cannot be null and only for bride or groom
	//, nullable = false)
	@Column(name = "betrothed")
	private boolean betrothed;



	// CONSTRUCTORS
	// Default Constructor
	public Users() {
		super();
	}
	
	// Full-Arg Constructor
	public Users(int user_id, String firstname, String lastname, String email, Meal_Types meal, boolean plus_one,
			Meal_Types plus_one_meal, Weddings wedding, boolean betrothed) {
		super();
		this.user_id = user_id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.meal = meal;
		this.plus_one = plus_one;
		this.plus_one_meal = plus_one_meal;
		this.wedding = wedding;
		this.betrothed = betrothed;
	}
	
	
	// GETTERS & SETTERS
	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
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

	public Meal_Types getMeal() {
		return meal;
	}

	public void setMeal(Meal_Types meal) {
		this.meal = meal;
	}

	public boolean isPlus_one() {
		return plus_one;
	}

	public void setPlus_one(boolean plus_one) {
		this.plus_one = plus_one;
	}

	public Meal_Types getPlus_one_meal() {
		return plus_one_meal;
	}

	public void setPlus_one_meal(Meal_Types plus_one_meal) {
		this.plus_one_meal = plus_one_meal;
	}

	public Weddings getWedding() {
		return wedding;
	}

	public void setWedding(Weddings wedding) {
		this.wedding = wedding;
	}

	public boolean isBetrothed() {
		return betrothed;
	}

	public void setBetrothed(boolean betrothed) {
		this.betrothed = betrothed;
	}

	@Override
	public String toString() {
		return "Users [user_id=" + user_id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", meal=" + meal + ", plus_one=" + plus_one + ", plus_one_meal=" + plus_one_meal + ", wedding="
				+ wedding + ", betrothed=" + betrothed + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(betrothed, email, firstname, lastname, meal, plus_one, plus_one_meal, user_id, wedding);
	}

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
				&& Objects.equals(meal, other.meal) && plus_one == other.plus_one
				&& Objects.equals(plus_one_meal, other.plus_one_meal) && user_id == other.user_id
				&& Objects.equals(wedding, other.wedding);
	}

	
		
}
