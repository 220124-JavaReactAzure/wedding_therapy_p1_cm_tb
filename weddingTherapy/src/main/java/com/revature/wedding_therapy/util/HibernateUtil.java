package com.revature.wedding_therapy.util;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.revature.wedding_therapy.models.*;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	private static Session session;
	
	public static Session getSession() throws IOException {
		if(sessionFactory == null) {
			Configuration configuration = new Configuration();
			Properties props = new Properties();
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			props.load(loader.getResourceAsStream("hibernate.properties"));
			
			// Add properties to our configuration
			configuration.setProperties(props);
			// ONE ADDITIONAL STEP I NEED TO INCLUDE
			configuration.addAnnotatedClass(Employee.class);
			configuration.addAnnotatedClass(Weddings.class);
			configuration.addAnnotatedClass(Users.class);
			configuration.addAnnotatedClass(Wedding_Services.class);
			configuration.addAnnotatedClass(Service_Types.class);
			configuration.addAnnotatedClass(Meal_Types.class);
	
			// ServiceRegistry
			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
			
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
		}
		
		if(session == null) {
			session = sessionFactory.openSession();
		}
		return session;
	}
	
	public static void closeSession() {
		session.close();
		session = null;
		
	}
}
