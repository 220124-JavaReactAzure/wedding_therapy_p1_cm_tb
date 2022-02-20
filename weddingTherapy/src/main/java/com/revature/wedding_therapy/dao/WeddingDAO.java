package com.revature.wedding_therapy.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.wedding_therapy.models.Weddings;
import com.revature.wedding_therapy.util.HibernateUtil;

public class WeddingDAO {

	public boolean createNewWedding(Weddings newWedding) {
		try {
			//System.out.println("\nWeddingDAO:createNewWedding\n");
			Session session = HibernateUtil.getSession();
			Transaction trans = session.beginTransaction();
			session.save(newWedding);
			trans.commit();

			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Weddings> findAllWeddings(){
		List<Weddings> weddingList = new ArrayList<>();
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
			return weddingList;
		}
	}

	public Weddings findWeddingByID(int id) {
		try {
			Session session = HibernateUtil.getSession();
			//Transaction trans = session.beginTransaction();
			Weddings wedding = session.get(Weddings.class, id);
			//trans.commit();
			return wedding;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

	public boolean updateWedding(Weddings wedding) {
		try {
			Session session = HibernateUtil.getSession();
			
			Transaction transaction = session.beginTransaction();
			session.merge(wedding);
			transaction.commit();
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return true;
		} finally {
			HibernateUtil.closeSession();
		}
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
			return true;
		}
	}

}
