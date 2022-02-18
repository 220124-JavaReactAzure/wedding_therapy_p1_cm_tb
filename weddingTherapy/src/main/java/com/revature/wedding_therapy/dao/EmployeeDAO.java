package com.revature.wedding_therapy.dao;

import java.io.IOException;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.revature.wedding_therapy.models.Employee;
import com.revature.wedding_therapy.util.HibernateUtil;
public class EmployeeDAO {

	public boolean createNewEmployee(Employee newEmployee) {
		try {
			Session session = HibernateUtil.getSession();
			session.save(newEmployee);
			
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
