package com.revature.wedding_therapy.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.wedding_therapy.models.Service_Types;
import com.revature.wedding_therapy.models.Weddings;
import com.revature.wedding_therapy.util.HibernateUtil;

public class Service_TypesDAO {

	
	
	public boolean createNewService_Type(Service_Types newService_Types) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction trans = session.beginTransaction();
			
			session.save(newService_Types);
			trans.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
		return true;
	}
	
	
	public List<Service_Types> getAllService_Types() {
		List<Service_Types> servList = null;
		try {
			Session session = HibernateUtil.getSession();
			Transaction trans = session.beginTransaction();
			
			servList = session.createQuery("FROM Service_Types").list();
			trans.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
		return servList;
	}
	
	
	public Service_Types getService_TypesID(int id) {
		Service_Types service_Types = null;
		try {
			Session session = HibernateUtil.getSession();
			Transaction trans = session.beginTransaction();
			
			service_Types = session.get(Service_Types.class, id);
			trans.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
		return service_Types;
	}
	
	
	public boolean updateService_Types(Service_Types oldService_Types) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			
			session.merge(oldService_Types);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
		return true;
	}
	
	
	public boolean deleteService_types(int id) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			
			Service_Types servType = session.get(Service_Types.class, id);
			session.delete(servType);
			
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
