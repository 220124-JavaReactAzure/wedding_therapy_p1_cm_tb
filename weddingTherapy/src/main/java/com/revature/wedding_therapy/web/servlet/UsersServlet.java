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
import com.revature.wedding_therapy.models.Users;
import com.revature.wedding_therapy.services.UsersService;

public class UsersServlet extends HttpServlet{
	
	
	private final UsersService usersService;
	private final ObjectMapper mapper;
	
	public UsersServlet(ObjectMapper mapper, UsersService usersService) {
		this.mapper = mapper;
		this.usersService = usersService;
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		try {
			Users newUsers = mapper.readValue(req.getInputStream(), Users.class);
			boolean wasReg = usersService.createNewUsers(newUsers);
			
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
		System.out.print("\n\n\nUsersServlet:doGet\n\n\n");
		PrintWriter writer = resp.getWriter();
		List<Users> users = usersService.getAllUsers();
		String payload = mapper.writeValueAsString(users);
		writer.write(payload);
		resp.setStatus(200);
	}

}
