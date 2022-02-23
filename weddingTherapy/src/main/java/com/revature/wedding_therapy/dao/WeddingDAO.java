package com.revature.wedding_therapy.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.wedding_therapy.models.Weddings;
import com.revature.wedding_therapy.util.HibernateUtil;

public class WeddingDAO {

	public boolean createNewWedding(Weddings newWedding) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction trans = session.beginTransaction();
			
			session.save(newWedding);
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
	public List<Weddings> findAllWeddings(){
		List<Weddings> weddingList = null;
		
		try {
			Session session = HibernateUtil.getSession();
			Transaction trans = session.beginTransaction();
			
			weddingList = session.createQuery("FROM Weddings").list();
			trans.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
		return weddingList;
	}

	public Weddings findWeddingByID(int id) {
		Weddings wedding = null;
		try {
			Session session = HibernateUtil.getSession();
			Transaction trans = session.beginTransaction();
			
			wedding = session.get(Weddings.class, id);
			trans.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
		return wedding;
	}

	public boolean updateWedding(Weddings wedding) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			
			session.merge(wedding);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
		return true;
	}

	public boolean deleteWedding(int id) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			
			Weddings wedding = session.get(Weddings.class, id);
			session.delete(wedding);
			
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
