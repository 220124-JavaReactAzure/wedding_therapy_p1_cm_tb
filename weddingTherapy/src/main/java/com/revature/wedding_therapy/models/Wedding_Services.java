package com.revature.wedding_therapy.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "wedding_services")
public class Wedding_Services {
	
	@Id
	@Column(name = "service_id")
	private int service_id;

	@Column(name = "service_name")
	private String service_name;

	@Column(name = "service_cost")
	private double service_cost;

//	@Column(name = "service_type_id")
//	private int service_type_id;
	
	@OneToOne
	private Service_Types service_type;

	
	// CONSTRUCTORS
	// Default Constructor
	public Wedding_Services() {
		super();
		// TODO Auto-generated constructor stub
	}

	// Full-Arg Constructor
	public Wedding_Services(int service_id, String service_name, double service_cost, Service_Types service_type) {
		super();
		this.service_id = service_id;
		this.service_name = service_name;
		this.service_cost = service_cost;
		this.service_type = service_type;
	}

	public int getService_id() {
		return service_id;
	}

	public void setService_id(int service_id) {
		this.service_id = service_id;
	}

	public String getService_name() {
		return service_name;
	}

	public void setService_name(String service_name) {
		this.service_name = service_name;
	}

	public double getService_cost() {
		return service_cost;
	}

	public void setService_cost(double service_cost) {
		this.service_cost = service_cost;
	}

	public Service_Types getService_type() {
		return service_type;
	}

	public void setService_type(Service_Types service_type) {
		this.service_type = service_type;
	}

	@Override
	public String toString() {
		return "Wedding_Services [service_id=" + service_id + ", service_name=" + service_name + ", service_cost="
				+ service_cost + ", service_type=" + service_type + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(service_cost, service_id, service_name, service_type);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Wedding_Services other = (Wedding_Services) obj;
		return Double.doubleToLongBits(service_cost) == Double.doubleToLongBits(other.service_cost)
				&& service_id == other.service_id && Objects.equals(service_name, other.service_name)
				&& Objects.equals(service_type, other.service_type);
	}

	

	
	
}
