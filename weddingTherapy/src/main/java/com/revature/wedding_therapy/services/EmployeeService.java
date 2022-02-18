package com.revature.wedding_therapy.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.wedding_therapy.dao.EmployeeDAO;
import com.revature.wedding_therapy.models.Employee;

public class EmployeeService {

	private EmployeeDAO employeeDAO;
	//private WeddingDAO weddingDAO;
	
	public EmployeeService(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	
	public boolean createNewEmployee(Employee account) {
		return employeeDAO.createNewEmployee(account);
	}
}
