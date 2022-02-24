package com.revature.wedding_therapy.models;

import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="weddings")
public class Weddings {

	@Id
	@Column(name="wedding_id")
	private int wedding_id;
	
	//this field must not be null, and not blank
	@Column(name="wedding_name", nullable = false)
	private String wedding_name;

	//this field must not be null, and not blank
	@Column(name="wedding_date", unique = true, nullable = false)
	private String wedding_date;

	//This field is not unique but cannot be null
	@Column(name="wedding_budget", nullable = false)
	private double wedding_budget;

	//This field is not unique but cannot be null
	@Column(name="caterer_id", nullable = false)
	private int caterer_id;

	//This field is not unique but cannot be null
	@Column(name="florist_id", nullable = false)
	private int florist_id;

	//This field is not unique but cannot be null
	@Column(name="musician_id", nullable = false)
	private int musician_id;

	//This field is not unique but cannot be null
	@Column(name="photographer_id", nullable = false)
	private int photographer_id;

	//This field is not unique but cannot be null
	@Column(name="venue_id", nullable = false)
	private int venue_id;

	@OneToMany(mappedBy = "wedding_name")
	private List<Users> allusers;
	
	// CONSTRUCTORS
	// Default Constructor
	public Weddings() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Full-Arg Constructor
	public Weddings(int wedding_id, String wedding_name, String wedding_date, 
			double wedding_budget, int caterer_id,int florist_id, int musician_id, 
			int photographer_id, int venue_id) {
		super();
		this.wedding_id = wedding_id;
		this.wedding_name = wedding_name;
		this.wedding_date = wedding_date;
		this.wedding_budget = wedding_budget;
		this.caterer_id = caterer_id;
		this.florist_id = florist_id;
		this.musician_id = musician_id;
		this.photographer_id = photographer_id;
		this.venue_id = venue_id;
	}

	
	// GETTERS & SETTERS
	public int getWedding_id() {
		return wedding_id;
	}

	public void setWedding_id(int wedding_id) {
		this.wedding_id = wedding_id;
	}

	public String getWedding_name() {
		return wedding_name;
	}

	public void setWedding_name(String wedding_name) {
		this.wedding_name = wedding_name;
	}

	public String getWedding_date() {
		return wedding_date;
	}

	public void setWedding_date(String wedding_date) {
		this.wedding_date = wedding_date;
	}

	public double getWedding_budget() {
		return wedding_budget;
	}

	public void setWedding_budget(double wedding_budget) {
		this.wedding_budget = wedding_budget;
	}

	public int getCaterer_id() {
		return caterer_id;
	}

	public void setCaterer_id(int caterer_id) {
		this.caterer_id = caterer_id;
	}

	public int getFlorist_id() {
		return florist_id;
	}

	public void setFlorist_id(int florist_id) {
		this.florist_id = florist_id;
	}

	public int getMusician_id() {
		return musician_id;
	}

	public void setMusician_id(int musician_id) {
		this.musician_id = musician_id;
	}

	public int getPhotographer_id() {
		return photographer_id;
	}

	public void setPhotographer_id(int photographer_id) {
		this.photographer_id = photographer_id;
	}

	public int getVenue_id() {
		return venue_id;
	}

	public void setVenue_id(int venue_id) {
		this.venue_id = venue_id;
	}

	
	// TOSTRING METHOD
	@Override
	public String toString() {
		return "Weddings [wedding_id=" + wedding_id + ", wedding_name=" + wedding_name + ", wedding_date="
				+ wedding_date + ", wedding_budget=" + wedding_budget + ", caterer_id=" + caterer_id + ", florist_id="
				+ florist_id + ", musician_id=" + musician_id + ", photographer_id=" + photographer_id + ", venue_id="
				+ venue_id + "]";
	}

	
	// HASHCODE METHOD
	@Override
	public int hashCode() {
		return Objects.hash(caterer_id, florist_id, musician_id, photographer_id, venue_id, wedding_budget,
				wedding_date, wedding_id, wedding_name);
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
		Weddings other = (Weddings) obj;
		return caterer_id == other.caterer_id && florist_id == other.florist_id && musician_id == other.musician_id
				&& photographer_id == other.photographer_id && venue_id == other.venue_id
				&& Double.doubleToLongBits(wedding_budget) == Double.doubleToLongBits(other.wedding_budget)
				&& Objects.equals(wedding_date, other.wedding_date) && wedding_id == other.wedding_id
				&& Objects.equals(wedding_name, other.wedding_name);
	}

}
