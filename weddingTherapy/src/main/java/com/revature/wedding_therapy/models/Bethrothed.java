package com.revature.wedding_therapy.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bethrothed")
public class Bethrothed {

	@Id
	@Column(name = "wedding_id")
	private int wedding_id;

	@Column(name = "wedding_name")
	private String wedding_name;

	@Column(name = "wedding_roll")
	private String wedding_roll;

	@Column(name = "first_name")
	private String first_name;

	@Column(name = "last_name")
	private String last_name;

	// CONSTRUCTORS
	// No-Arg Constructor
	public Bethrothed() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Full-Arg Constructor
	public Bethrothed(int wedding_id, String wedding_name, String wedding_roll, String first_name, String last_name) {
		super();
		this.wedding_id = wedding_id;
		this.wedding_name = wedding_name;
		this.wedding_roll = wedding_roll;
		this.first_name = first_name;
		this.last_name = last_name;
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

	public String getWedding_roll() {
		return wedding_roll;
	}

	public void setWedding_roll(String wedding_roll) {
		this.wedding_roll = wedding_roll;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	// TOSTRING METHOD
	@Override
	public String toString() {
		return "Bethrothed [wedding_id=" + wedding_id + ", wedding_name=" + wedding_name + ", wedding_roll="
				+ wedding_roll + ", first_name=" + first_name + ", last_name=" + last_name + "]";
	}
		
	//HASHCODE
	@Override
	public int hashCode() {
		return Objects.hash(first_name, last_name, wedding_id, wedding_name, wedding_roll);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bethrothed other = (Bethrothed) obj;
		return Objects.equals(first_name, other.first_name) && Objects.equals(last_name, other.last_name)
				&& wedding_id == other.wedding_id && Objects.equals(wedding_name, other.wedding_name)
				&& Objects.equals(wedding_roll, other.wedding_roll);
	}
	
}
