package com.revature.wedding_therapy.services;

import java.util.List;
import java.util.Random;

import com.revature.wedding_therapy.dao.WeddingDAO;
import com.revature.wedding_therapy.models.Weddings;
import com.revature.wedding_therapy.exceptions.*;

public class WeddingService {
	
	private WeddingDAO weddingDAO;
	
	public WeddingService(WeddingDAO weddingDAO) {
		this.weddingDAO = weddingDAO;
	}
	
	
	public boolean createNewWedding(Weddings newWedding) throws WeddingNotNamedException {
		if(!validWedding(newWedding)){
			throw new WeddingNotNamedException("Please Give This Wedding A Name!");
		}
		return weddingDAO.createNewWedding(newWedding);
	}
	
	
	public List<Weddings> findAllWeddings(){
		return weddingDAO.findAllWeddings();
	}
	
	
	public Weddings getWedding(int wedding_id) {
		if(!validId(wedding_id)) {return null;}
		return weddingDAO.findWeddingByID(wedding_id);
	}
	
	
	public boolean updateWedding(Weddings wedding) {
		return weddingDAO.updateWedding(wedding);
	}
	
	
	public boolean deleteWedding(int wedding_id) {
		if(!validId(wedding_id)) {return false;}
		return weddingDAO.deleteWedding(wedding_id);
	}
	
	
	private boolean validWedding(Weddings newWedding) {
		if(newWedding.getWedding_name() == null || newWedding.getWedding_name().equals("") || 
				newWedding.getWedding_date() == null || newWedding.getWedding_date().equals("") || 
		newWedding.getWedding_budget() <= 0 ) {
			return false;
		}
		return true;
	}

	
	private boolean validId(int id) {
		if(99999 >= id && id >= 1) {
			return true;
		}
		return false;
	}
}
