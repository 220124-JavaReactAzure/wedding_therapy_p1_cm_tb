package com.revature.wedding_therapy.web.servlet;

import java.io.IOException;
import java.util.List;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.wedding_therapy.models.Employee;
import com.revature.wedding_therapy.services.EmployeeService;

public class EmployeeServlet extends HttpServlet{
	
	private final EmployeeService employeeService;
	private final ObjectMapper mapper;
	
	public EmployeeServlet(ObjectMapper mapper, EmployeeService employeeService) {
		this.mapper = mapper;
		this.employeeService = employeeService;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		try {
			Employee newEmployee = mapper.readValue(req.getInputStream(), Employee.class);
			boolean wasReg = employeeService.createNewEmployee(newEmployee);
			
			if(wasReg) {
				resp.setStatus(201);
			} else {
				resp.setStatus(500);
				resp.getWriter().write("Database did not persist");
			}
		} catch (StreamReadException | DatabindException e) {
			resp.setStatus(400);
			resp.getWriter().write("JSON threw exception");
			e.printStackTrace();
		} catch (Exception e) {
			resp.setStatus(500);
			resp.getWriter().write("Some other random exception did not persist");
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.print("\n\n\nEmployeeServlet:doGet\n\n\n");
		PrintWriter writer = resp.getWriter();
		List<Employee> employees = employeeService.getAllEmployees();
		String payload = mapper.writeValueAsString(employees);
		writer.write(payload);
		resp.setStatus(200);
	}

}
