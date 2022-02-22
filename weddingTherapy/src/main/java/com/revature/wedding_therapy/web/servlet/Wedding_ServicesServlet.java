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
import com.revature.wedding_therapy.models.Wedding_Services;
import com.revature.wedding_therapy.services.Wedding_ServicesService;

public class Wedding_ServicesServlet extends HttpServlet{
	
	ObjectMapper mapper;
	Wedding_ServicesService wedding_servicesService;
	
	public Wedding_ServicesServlet(ObjectMapper mapper, Wedding_ServicesService wedding_servicesService) {
		this.mapper = mapper;
		this.wedding_servicesService = wedding_servicesService;
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		try {
			Wedding_Services wedservice = mapper.readValue(req.getInputStream(), Wedding_Services.class);
			boolean wasReg = wedding_servicesService.createWedding_Services(wedservice);

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
				String idParam = req.getParameter("weddingServiceId");
				if (idParam == null) {
					resp.setStatus(400);
					writer.write("Please include the query ?weddingServiceId=# in your url");
					return;
				}

				int weddingServiceId = Integer.valueOf(idParam);

				Wedding_Services wedService = wedding_servicesService.getWedding_Services(weddingServiceId);
				if (wedService == null) {
					resp.setStatus(500);
					return;
				}
				String payload = mapper.writeValueAsString(wedService);
				writer.write(payload);
				resp.setStatus(200);
			} catch (StreamReadException | DatabindException e) {
				resp.setStatus(400);
			}
			break;
		default:
			System.out.print("\nWedding_ServicesServlet:GetAll\n");
			List<Wedding_Services> wedServices = wedding_servicesService.getAllWedding_Services();
			String payload = mapper.writeValueAsString(wedServices.toString().toString());
			writer.write(payload);
			resp.setStatus(200);
			break;
		}
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Wedding_Services wedService = mapper.readValue(req.getInputStream(), Wedding_Services.class);
			wedding_servicesService.updateWedding_Services(wedService);
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
			String idParam = req.getParameter("weddingServiceId");
			if (idParam == null) {
				resp.setStatus(400);
				writer.write("Please include the query ?weddingServiceId=# in your url");
				return;
			}

			int weddingServiceId = Integer.valueOf(idParam);

			boolean delete = wedding_servicesService.deleteWedding_Services(weddingServiceId);
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
