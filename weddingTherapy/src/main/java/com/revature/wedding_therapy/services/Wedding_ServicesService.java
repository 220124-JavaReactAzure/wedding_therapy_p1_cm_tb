package com.revature.wedding_therapy.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.wedding_therapy.dao.Wedding_ServicesDAO;
import com.revature.wedding_therapy.exceptions.WeddingNotNamedException;
import com.revature.wedding_therapy.exceptions.Wedding_ServiceNotNamedException;
import com.revature.wedding_therapy.models.Wedding_Services;

public class Wedding_ServicesService {

	private Wedding_ServicesDAO wedding_servicesDAO;

	public Wedding_ServicesService(Wedding_ServicesDAO wedding_servicesDAO) {
		this.wedding_servicesDAO = wedding_servicesDAO;
	}
	
	
	public boolean createWedding_Services(Wedding_Services newWedding_Service) throws Wedding_ServiceNotNamedException {
		if(newWedding_Service.getService_name() == null || newWedding_Service.getService_name().equals("")) {
			throw new Wedding_ServiceNotNamedException("Please Give This Wedding Service A Name!");
		}
		return wedding_servicesDAO.createNewWedding_Services(newWedding_Service);
	}
	
	public List<Wedding_Services> getAllWedding_Services() {
		System.out.print("\nWedding_ServicesService:GetAllWedding_Services\n");
		return wedding_servicesDAO.getAllWedding_Services();
	}
	
	public Wedding_Services getWedding_Services(int weddingServiceId) {
		return wedding_servicesDAO.getWedding_Services(weddingServiceId);
	}
	
	public boolean updateWedding_Services(Wedding_Services wedService) {
		return wedding_servicesDAO.updateWedding_Services(wedService);
	}
	
	public boolean deleteWedding_Services(int id) {
		return wedding_servicesDAO.deleteWedding_Services(id);
	}
}
