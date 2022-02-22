package com.revature.wedding_therapy.web.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.revature.wedding_therapy.dao.*;
import com.revature.wedding_therapy.services.*;
import com.revature.wedding_therapy.web.servlet.*;

@WebListener
public class ContextLoaderListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new Hibernate5Module());
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		EmployeeService employeeService = new EmployeeService(employeeDAO);
		EmployeeServlet employeeServlet = new EmployeeServlet(mapper, employeeService);
		
		WeddingDAO weddingDAO = new WeddingDAO();
		WeddingService weddingService = new WeddingService(weddingDAO);
		WeddingServlet weddingServlet = new WeddingServlet(mapper, weddingService);
		
		UsersDAO usersDAO = new UsersDAO();
		UsersService usersService = new UsersService(usersDAO);
		UsersServlet usersServlet = new UsersServlet(mapper, usersService);
		
		Wedding_ServicesDAO wedServicesDAO = new Wedding_ServicesDAO();
		Wedding_ServicesService wedServicesService = new Wedding_ServicesService(wedServicesDAO);
		Wedding_ServicesServlet wedServicesServlet = new Wedding_ServicesServlet(mapper, wedServicesService);
		
		ServletContext context = sce.getServletContext();
		context.addServlet("EmployeeServlet", employeeServlet).addMapping("/employee/*");
		context.addServlet("UserServlet", usersServlet).addMapping("/users/*");
		context.addServlet("WeddingServlet", weddingServlet).addMapping("/wedding/*");
		context.addServlet("Wedding_ServicesServlet", wedServicesServlet).addMapping("/wedservice/*");
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}
	
}
