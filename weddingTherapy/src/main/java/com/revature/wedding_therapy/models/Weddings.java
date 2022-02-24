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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="weddings")
public class Weddings {

	@Id
	@Column(name="wedding_id")
	private int wedding_id;
	
	//this field must not be null, and not blank
	//, nullable = false)
	@Column(name="wedding_name")
	private String wedding_name;

	//this field must not be null, and not blank
	//, unique = true, nullable = false)
	@Column(name="wedding_date")
	private String wedding_date;

	//This field is not unique but cannot be null
	//, nullable = false)
	@Column(name="wedding_budget")
	private double wedding_budget;

	//columnDefinition = "VARCHAR CHECK (firstname <> '')")
	@OneToOne
	private Wedding_Services venue;

	@OneToOne
	private Wedding_Services musician;
	
	@OneToOne
	private Wedding_Services caterer;

	@OneToOne
	private Wedding_Services florist;

	@OneToOne
	private Wedding_Services photographer;

	
	// CONSTRUCTORS
	// Default Constructor
	public Weddings() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	// Full-Arg Constructor
	public Weddings(int wedding_id, String wedding_name, String wedding_date, 
			double wedding_budget, Wedding_Services caterer, Wedding_Services florist, Wedding_Services musician, 
			Wedding_Services photographer, Wedding_Services venue) {
		super();
		this.wedding_id = wedding_id;
		this.wedding_name = wedding_name;
		this.wedding_date = wedding_date;
		this.wedding_budget = wedding_budget;
		this.caterer = caterer;
		this.florist = florist;
		this.musician = musician;
		this.photographer = photographer;
		this.venue = venue;
	}

	
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

	public Wedding_Services getVenue() {
		return venue;
	}

	public void setVenue(Wedding_Services venue) {
		this.venue = venue;
	}

	public Wedding_Services getMusician() {
		return musician;
	}

	public void setMusician(Wedding_Services musician) {
		this.musician = musician;
	}

	public Wedding_Services getCaterer() {
		return caterer;
	}

	public void setCaterer(Wedding_Services caterer) {
		this.caterer = caterer;
	}

	public Wedding_Services getFlorist() {
		return florist;
	}

	public void setFlorist(Wedding_Services florist) {
		this.florist = florist;
	}

	public Wedding_Services getPhotographer() {
		return photographer;
	}

	public void setPhotographer(Wedding_Services photographer) {
		this.photographer = photographer;
	}


	@Override
	public String toString() {
		return "Weddings [wedding_id=" + wedding_id + ", wedding_name=" + wedding_name + ", wedding_date="
				+ wedding_date + ", wedding_budget=" + wedding_budget + ", venue=" + venue + ", musician=" + musician
				+ ", caterer=" + caterer + ", florist=" + florist + ", photographer=" + photographer + "]";
	}


	@Override
	public int hashCode() {
		return Objects.hash(caterer, florist, musician, photographer, venue, wedding_budget, wedding_date, wedding_id,
				wedding_name);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Weddings other = (Weddings) obj;
		return Objects.equals(caterer, other.caterer) && Objects.equals(florist, other.florist)
				&& Objects.equals(musician, other.musician) && Objects.equals(photographer, other.photographer)
				&& Objects.equals(venue, other.venue)
				&& Double.doubleToLongBits(wedding_budget) == Double.doubleToLongBits(other.wedding_budget)
				&& Objects.equals(wedding_date, other.wedding_date) && wedding_id == other.wedding_id
				&& Objects.equals(wedding_name, other.wedding_name);
	}

	

}
