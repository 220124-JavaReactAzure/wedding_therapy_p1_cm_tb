package com.revature.wedding_therapy.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.wedding_therapy.models.Meal_Types;
import com.revature.wedding_therapy.util.HibernateUtil;

public class Meal_TypesDAO {

	public boolean createNewMeal_Types(Meal_Types newMeal_Types) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction trans = session.beginTransaction();
			
			session.save(newMeal_Types);
			trans.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
		return true;
	}
	
	
	public List<Meal_Types> getAllMeal_Types(){
		List<Meal_Types> meals = null;
		
		try {
			Session session = HibernateUtil.getSession();
			Transaction trans = session.beginTransaction();
			
			meals = session.createQuery("FROM Meal_Types").list();
			trans.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
		return meals;
	}
	
	
	public Meal_Types getMeal_TypesId(int id) {
		Meal_Types meal = null;
		try {
			Session session = HibernateUtil.getSession();
			Transaction trans = session.beginTransaction();
			
			meal = session.get(Meal_Types.class, id);
			trans.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
		return meal;
	}
	
	
	public boolean updateMeal_Types(Meal_Types oldMeal_Types) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			
			session.merge(oldMeal_Types);
			transaction.commit();
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
		return true;
	}
	
	
	public boolean deleteMeal_Types(int id) {
		try {
			Session session = HibernateUtil.getSession();
			Transaction transaction = session.beginTransaction();
			
			Meal_Types meal = session.get(Meal_Types.class, id);
			session.delete(meal);
			
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
