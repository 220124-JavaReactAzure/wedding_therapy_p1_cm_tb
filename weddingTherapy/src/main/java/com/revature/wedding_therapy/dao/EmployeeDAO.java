package com.revature.wedding_therapy.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.revature.wedding_therapy.models.Employee;
import com.revature.wedding_therapy.util.HibernateUtil;
public class EmployeeDAO {

	public boolean createNewEmployee(Employee newEmployee) {
		try {
			
			Session session = HibernateUtil.getSession();
			System.out.println("\n\n\nEmployeeDAO:createNewEmployee\n\n\n"+newEmployee.toString());
			Transaction trans = session.beginTransaction();
			session.save(newEmployee);
			trans.commit();            // Make sure to put transactions arround all DAO actions so it works.
			
			return true;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return false;
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	
	public List<Employee> getAllEmployees(){
		try {
			System.out.print("\n\n\n\n\nEmployDAO:getAllEmployees\n\n\n\n\n");
			Session session = HibernateUtil.getSession();
			List<Employee> answer = session.createQuery("FROM employees").list();
			return answer;
		} catch (HibernateException | IOException e) {
			e.printStackTrace();
			return null;
		} finally {
			HibernateUtil.closeSession();
		}
	}
}
