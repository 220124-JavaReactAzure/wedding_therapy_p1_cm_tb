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
			
			Session session = HibernateUtil.getSession();
			System.out.println("\n\n\nUsersDAO:createNewUsers\n\n\n"+newUsers.toString());
			Transaction trans = session.beginTransaction();
			session.save(newUsers);
			trans.commit();            // Make sure to put transactions around all DAO actions so it works.
			
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	
	public List<Users> getAllUsers(){
		try {
			System.out.print("\n\n\n\n\nUsersDAO:getAllUsers\n\n\n\n\n");
			Session session = HibernateUtil.getSession();
			List<Users> answer = session.createQuery("FROM users").list();
			return answer;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}

}
