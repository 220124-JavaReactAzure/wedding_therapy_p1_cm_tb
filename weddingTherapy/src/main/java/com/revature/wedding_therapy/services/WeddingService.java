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
		if(newWedding.getWedding_name() == null || newWedding.getWedding_name().equals("")) {
			throw new WeddingNotNamedException("Please Give This Wedding A Name!");
		}
		return weddingDAO.createNewWedding(newWedding);
	}
	
	public List<Weddings> findAllWeddings(){
		return weddingDAO.findAllWeddings();
	}
	
	
	public Weddings getWedding(int wedding_id) {
		return weddingDAO.findWeddingByID(wedding_id);
	}
	
	
	public boolean updateWedding(Weddings wedding) {
		return weddingDAO.updateWedding(wedding);
	}
	
	
	public boolean deleteWedding(int wedding_id) {
		//System.out.println("\nWeddingService:deleteWedding\n");
		return weddingDAO.deleteWedding(wedding_id);
	}

}
