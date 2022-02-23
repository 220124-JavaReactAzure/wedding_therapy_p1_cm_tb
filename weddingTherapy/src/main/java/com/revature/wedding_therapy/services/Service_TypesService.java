package com.revature.wedding_therapy.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.wedding_therapy.exceptions.Service_TypesNotNamedException;
import com.revature.wedding_therapy.dao.Service_TypesDAO;
import com.revature.wedding_therapy.models.Service_Types;

public class Service_TypesService {
	
	private Service_TypesDAO service_TypesDAO;
	
	public Service_TypesService(Service_TypesDAO service_TypesDAO) {
		this.service_TypesDAO = service_TypesDAO;		
	}

	
	public boolean createNewService_Types(Service_Types service_Types) throws Service_TypesNotNamedException {
		if(service_Types.getService() == null || service_Types.getService().equals("")) {
			throw new Service_TypesNotNamedException("Please Name This Service");
		}
		return service_TypesDAO.createNewService_Type(service_Types);
	}
	
	
	public List<Service_Types> getAllService_Types() {
		return service_TypesDAO.getAllService_Types();
	}
	
	
	public Service_Types getService_TypesId(int id) {
		return service_TypesDAO.getService_TypesID(id);
	}
	
	
	public boolean updateService_Types(Service_Types service_Types) {
		System.out.print("\nService_TypeService:updateService\n");
		return service_TypesDAO.updateService_Types(service_Types);
	}
	
	
	public boolean deleteServce_Types(int id) {
		return service_TypesDAO.deleteService_types(id);
	}
}
