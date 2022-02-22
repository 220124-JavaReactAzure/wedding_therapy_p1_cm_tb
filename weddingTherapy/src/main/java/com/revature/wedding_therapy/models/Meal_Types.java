package com.revature.wedding_therapy.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "meal_types")
public class Meal_Types {

	@Id
	@Column(name = "meal_id")
	private int meal_id;
	
	@Column(name = "meal_type")
	private String meal_type;
	
	public Meal_Types() {
		super();
	}
	
	public Meal_Types(int meal_id, String meal_type) {
		this.meal_id = meal_id;
		this.meal_type = meal_type;
	}

	public int getMeal_id() {
		return meal_id;
	}

	public void setMeal_id(int meal_id) {
		this.meal_id = meal_id;
	}

	public String getMeal_type() {
		return meal_type;
	}

	public void setMeal_type(String meal_type) {
		this.meal_type = meal_type;
	}

	@Override
	public String toString() {
		return "Meal_Types [meal_id=" + meal_id + ", meal_type=" + meal_type + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(meal_id, meal_type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Meal_Types other = (Meal_Types) obj;
		return meal_id == other.meal_id && Objects.equals(meal_type, other.meal_type);
	}
	
	
}
