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
import com.revature.wedding_therapy.models.Weddings;
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
		System.out.print("\nUsersServlet:doPost\n");
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
	
//	@Override
//	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		System.out.print("\nUsersServlet:doGet\n");
//		PrintWriter writer = resp.getWriter();
//		List<Users> users = usersService.getAllUsers();
//		String payload = mapper.writeValueAsString(users);
//		writer.write(payload);
//		resp.setStatus(200);
//	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.print("\nUsersServlet:doGet\n");
		
		PrintWriter writer = resp.getWriter();
		
		String path = req.getPathInfo();
		if (path == null)
			path = "";
		switch (path) {
		case "/ID":
			try {
				String idParam = req.getParameter("userId");
				if (idParam == null) {
					resp.setStatus(400);
					writer.write("Please include the query ?usersId=# in your url");
					return;
				}

				int userId = Integer.valueOf(idParam);

				Users user = usersService.getUserId(userId);
				if (user == null) {
					resp.setStatus(500);
					return;
				}
				String payload = mapper.writeValueAsString(user);
				writer.write(payload);
				resp.setStatus(200);
			} catch (StreamReadException | DatabindException e) {
				resp.setStatus(400);
			}
			break;
		default:
			List<Users> userList = usersService.getAllUsers();
			String payload = mapper.writeValueAsString(userList.toString().toString());
			writer.write(payload);
			resp.setStatus(200);
			break;
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			System.out.print("\nUsersServlet:doPut\n");
			Users user = mapper.readValue(req.getInputStream(), Users.class);
			usersService.updateUsers(user);
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
			System.out.print("\nUsersServlet:doDelete\n");
			PrintWriter writer = resp.getWriter();
			String idParam = req.getParameter("userId");
			if (idParam == null) {
				resp.setStatus(400);
				writer.write("Please include the query ?userId=# in your url");
				return;
			}

			int userId = Integer.valueOf(idParam);

			boolean delete = usersService.deleteUsers(userId);
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
