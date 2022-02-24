package com.revature.wedding_therapy.web.util;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.hibernate5.Hibernate5Module;
import com.revature.wedding_therapy.dao.*;
import com.revature.wedding_therapy.services.*;
import com.revature.wedding_therapy.web.servlet.*;

@WebListener
public class ContextLoaderListener implements ServletContextListener{

	private final Logger logger = LogManager.getLogger(ContextLoaderListener.class);
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		logger.info("\nWedding Therapy is Initializing . . . .\n");
		//System.out.print("\nWedding Therpay Initializing . . . .\n");
		
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
		
		Service_TypesDAO service_TypesDAO = new Service_TypesDAO();
		Service_TypesService service_TypesService = new Service_TypesService(service_TypesDAO);
		Service_TypeServlet service_TypesServlet = new Service_TypeServlet(mapper, service_TypesService);
		
		Meal_TypesDAO meal_TypesDAO = new Meal_TypesDAO();
		Meal_TypesService meal_TypesService = new Meal_TypesService(meal_TypesDAO);
		Meal_TypesServlet meal_TypesServlet = new Meal_TypesServlet(mapper, meal_TypesService);
		
		ServletContext context = sce.getServletContext();
		context.addServlet("EmployeeServlet", employeeServlet).addMapping("/employee/*");
		context.addServlet("UserServlet", usersServlet).addMapping("/users/*");
		context.addServlet("WeddingServlet", weddingServlet).addMapping("/wedding/*");
		context.addServlet("Wedding_ServicesServlet", wedServicesServlet).addMapping("/wedservice/*");
		context.addServlet("Service_TypeServlet", service_TypesServlet).addMapping("/servicetype/*");
		context.addServlet("Meal_TypesServlet", meal_TypesServlet).addMapping("/mealtypes/*");
		
		logger.info("\nWedding Therapy is Initialized\n");
		//System.out.print("\nWedding Therapy is Initialized\n");
		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		ServletContextListener.super.contextDestroyed(sce);
	}
	
}
