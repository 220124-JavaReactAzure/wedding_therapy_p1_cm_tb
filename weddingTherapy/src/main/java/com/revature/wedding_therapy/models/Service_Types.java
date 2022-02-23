package com.revature.wedding_therapy.models;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "service_types")
public class Service_Types {

	@Id
	@Column(name = "service_type_id")
	private int service_type_id;
	
	@Column(name = "service")
	private String service;
	
	public Service_Types() {
		super();
	}
	
	public Service_Types(int serviceTypeId, String service) {
		this.service_type_id = serviceTypeId;
		this.service = service;
	}

	public int getService_type_id() {
		return service_type_id;
	}

	public void setService_type_id(int service_type_id) {
		this.service_type_id = service_type_id;
	}

	public String getService() {
		return service;
	}
	
	public void setService(String service) {
		this.service = service;
	}

	@Override
	public String toString() {
		return "Service_Types [service_type_id=" + service_type_id + ", service=" + service + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(service, service_type_id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Service_Types other = (Service_Types) obj;
		return Objects.equals(service, other.service) && service_type_id == other.service_type_id;
	}

	
	
	
}
