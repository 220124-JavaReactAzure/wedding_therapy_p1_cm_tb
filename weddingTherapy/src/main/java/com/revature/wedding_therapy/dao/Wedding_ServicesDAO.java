package com.revature.wedding_therapy.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.wedding_therapy.models.Wedding_Services;
import com.revature.wedding_therapy.models.Weddings;
import com.revature.wedding_therapy.util.HibernateUtil;

public class Wedding_ServicesDAO {

	public boolean createNewWedding_Services(Wedding_Services wedservice) {
		try {
			//System.out.println("\nWedding_ServicesDAO:createNewWedding_Services\n");
			Session session = HibernateUtil.getSession();
			Transaction trans = session.beginTransaction();
			session.save(wedservice);
			trans.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
		return true;
	}
	
	@SuppressWarnings("unchecked")
	public List<Wedding_Services> getAllWedding_Services() {
		List<Wedding_Services> wedServices = new ArrayList<>();
		try {
			Session session = HibernateUtil.getSession();
			Transaction trans = session.beginTransaction();
			wedServices = session.createQuery("FROM Wedding_Services").list();
			trans.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
		return wedServices;
	}
	
	public Wedding_Services getWedding_Services(int weddingServicesId) {
		Wedding_Services wedService = null;
		try {
			Session session = HibernateUtil.getSession();
			Transaction trans = session.beginTransaction();
			wedService = session.get(Wedding_Services.class, weddingServicesId);
			trans.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
		return wedService;
	}
	
	public boolean updateWedding_Services(Wedding_Services wedService) {
		try {
			Session session = HibernateUtil.getSession();
			
			Transaction transaction = session.beginTransaction();
			session.merge(wedService);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
		return true;
		
	}
	
	public boolean deleteWedding_Services(int id) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			Wedding_Services wedService = session.get(Wedding_Services.class, id);
			session.delete(wedService);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} 
		finally {
			HibernateUtil.closeSession();
		}
		return true;
	}
	
}
