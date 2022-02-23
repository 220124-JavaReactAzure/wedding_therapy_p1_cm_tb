package com.revature.wedding_therapy.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.wedding_therapy.models.Meal_Types;
import com.revature.wedding_therapy.models.Weddings;
import com.revature.wedding_therapy.services.Meal_TypesService;

public class Meal_TypesServlet extends HttpServlet{

	private ObjectMapper mapper;
	private Meal_TypesService meal_TypesService;
	
	public Meal_TypesServlet(ObjectMapper mapper, Meal_TypesService meal_TypesService) {
		this.mapper = mapper;
		this.meal_TypesService = meal_TypesService;
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		try {
			Meal_Types meal = mapper.readValue(req.getInputStream(), Meal_Types.class);
			boolean wasReg = meal_TypesService.createNewMeal_Type(meal);

			if (wasReg) {
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
		PrintWriter writer = resp.getWriter();
		
		String path = req.getPathInfo();
		if (path == null)
			path = "";
		switch (path) {
		case "/ID":
			try {
				String idParam = req.getParameter("mealId");
				if (idParam == null) {
					resp.setStatus(400);
					writer.write("Please include the query ?mealId=# in your url");
					return;
				}

				int mealId = Integer.valueOf(idParam);

				Meal_Types meal = meal_TypesService.getMeal_TypeId(mealId);
				if (meal == null) {
					resp.setStatus(500);
					return;
				}
				String payload = mapper.writeValueAsString(meal);
				writer.write(payload);
				resp.setStatus(200);
			} catch (StreamReadException | DatabindException e) {
				resp.setStatus(400);
			}
			break;
		default:
			List<Meal_Types> meals = meal_TypesService.getAllMeal_Types();
			String payload = mapper.writeValueAsString(meals.toString().toString());
			writer.write(payload);
			resp.setStatus(200);
			break;
		}
	}
	
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Meal_Types meal = mapper.readValue(req.getInputStream(), Meal_Types.class);
			meal_TypesService.updateMeal_Types(meal);
			resp.setStatus(204);
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
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			PrintWriter writer = resp.getWriter();
			String idParam = req.getParameter("mealId");
			if (idParam == null) {
				resp.setStatus(400);
				writer.write("Please include the query ?MealId=# in your url");
				return;
			}

			int mealId = Integer.valueOf(idParam);

			boolean delete = meal_TypesService.deleteMeal_Types(mealId);
			if (delete) {
				resp.setStatus(200);
				return;
			}
			else {
				resp.setStatus(500);
				resp.getWriter().write("Database did not delete");
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
	
}
