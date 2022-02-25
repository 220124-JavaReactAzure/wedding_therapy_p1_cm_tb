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
		System.out.print("\nWeddingService:createNewWedding\n");
		if(!validWedding(newWedding)){
			throw new WeddingNotNamedException("Please Give This Wedding A Name!");
		}
		
		if(!validWeddingServices(newWedding)) {return false;}
		
		return weddingDAO.createNewWedding(newWedding);
	}
	
	
	public List<Weddings> findAllWeddings(){
		System.out.print("\nWeddingService:findAllWeddings\n");
		return weddingDAO.findAllWeddings();
	}
	
	
	public Weddings getWedding(int wedding_id) {
		System.out.print("\nWeddingService:getWedding\n");
		if(!validId(wedding_id)) {return null;}
		return weddingDAO.findWeddingByID(wedding_id);
	}
	
	
	public boolean updateWedding(Weddings wedding) {
		System.out.print("\nWeddingService:updateWedding\n");
		if(!validWedding(wedding) || !validWeddingServices(wedding)) {
			return false;
		}
		return weddingDAO.updateWedding(wedding);
	}
	
	
	public boolean deleteWedding(int wedding_id) {
		System.out.print("\nWeddingService:deleteWedding\n");
		if(!validId(wedding_id)) {return false;}
		return weddingDAO.deleteWedding(wedding_id);
	}
	
	
	public boolean validWedding(Weddings newWedding) {
		if(newWedding.getWedding_id() < 0 || newWedding.getWedding_id() > 99999 || newWedding.getWedding_name() == null || 
				newWedding.getWedding_name().trim().equals("") || newWedding.getWedding_date() == null || 
				newWedding.getWedding_date().trim().equals("") || 
					newWedding.getWedding_budget() < 0 ) {
			return false;
		}
		return true;
	}
	
	public boolean validWeddingServices(Weddings wedding) {
		if( !(wedding.getCaterer().getService_type().getService().equals("caterers") || wedding.getCaterer().getService_type().getService().equals("Empty")) ||
			!(wedding.getFlorist().getService_type().getService().equals("florists") || wedding.getFlorist().getService_type().getService().equals("Empty")) ||
			!(wedding.getMusician().getService_type().getService().equals("musician") || wedding.getMusician().getService_type().getService().equals("Empty")) ||
		   !(wedding.getPhotographer().getService_type().getService().equals("photographers") || wedding.getPhotographer().getService_type().getService().equals("Empty")) ||
			!(wedding.getVenue().getService_type().getService().equals("venues") || wedding.getVenue().getService_type().getService().equals("Empty"))
			) {return false;}
		return true;
			
	}

	
	public boolean validId(int id) {
		if(99999 >= id && id >= 0) {
			return true;
		}
		return false;
	}
}
