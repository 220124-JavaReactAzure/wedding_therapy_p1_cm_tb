package com.revature.wedding_therapy.dao;

import java.io.IOException;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.wedding_therapy.models.Users;
import com.revature.wedding_therapy.util.HibernateUtil;

public class UsersDAO {
	
	public boolean createNewUser(Users newUsers) {
		try {
			System.out.println("\nUsersDAO:createNewUsers\n"+newUsers.toString()+"\n");
			Session session = HibernateUtil.getSession();
			Transaction trans = session.beginTransaction();
			
			session.save(newUsers);
			trans.commit();     
			
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
		return true;
	}
	
	
	public List<Users> getAllUsers(){
		try {
			System.out.print("\nUsersDAO:getAllUsers\n");
			Session session = HibernateUtil.getSession();
			List<Users> answer = session.createQuery("FROM Users").list();
			return answer;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

}
