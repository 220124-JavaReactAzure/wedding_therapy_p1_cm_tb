package com.revature.wedding_therapy.services;

import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.wedding_therapy.dao.EmployeeDAO;
import com.revature.wedding_therapy.exceptions.InvalidRequestException;
import com.revature.wedding_therapy.models.Employee;
import com.revature.wedding_therapy.models.Users;

public class EmployeeService {

	private EmployeeDAO employeeDAO;
	//private WeddingService weddingService;
	
	public EmployeeService(EmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}
	
	
//	public boolean createNewEmployee(Employee account) {
//		return employeeDAO.createNewEmployee(account);
//	}
	
	public boolean createNewEmployee(Employee account) throws InvalidRequestException {
		System.out.print("\nUsersService:createNewUsers\n");
		if(!isEmployeeValid(account)) {
			throw new InvalidRequestException("Invalid employee information provided");
		}
		return employeeDAO.createNewEmployee(account);
	}
	
	public List<Employee> getAllEmployees(){
		System.out.print("\n\n\nEmployeeService:getAllEmployees\n\n\n");
		return employeeDAO.getAllEmployees();
	}
	
	private boolean isEmployeeValid(Employee account) {
		if(account == null) return false;
		if(account.getUsername() == null || account.getUsername().trim().equals("")) return false;
		if(account.getEmail() == null || account.getEmail().trim().equals("")) return false;
		if(account.getPassword() == null || account.getPassword().trim().equals("")) return false;
		return true;
	}
	
}
