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
import com.revature.wedding_therapy.models.Service_Types;
import com.revature.wedding_therapy.services.Service_TypesService;

@SuppressWarnings("serial")
public class Service_TypeServlet extends HttpServlet{

	private ObjectMapper mapper;
	private Service_TypesService service_TypesService;
	
	public Service_TypeServlet(ObjectMapper mapper, Service_TypesService service_TypesService) {
		this.mapper = mapper;
		this.service_TypesService = service_TypesService;
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		try {
			Service_Types newServe = mapper.readValue(req.getInputStream(), Service_Types.class);
			boolean wasReg = service_TypesService.createNewService_Types(newServe);

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
				String idParam = req.getParameter("servTypeId");
				if (idParam == null) {
					resp.setStatus(400);
					writer.write("Please include the query ?servTypeId=# in your url");
					return;
				}

				int weddingId = Integer.valueOf(idParam);

				Service_Types servType = service_TypesService.getService_TypesId(weddingId);
				if (servType == null) {
					resp.setStatus(500);
					return;
				}
				String payload = mapper.writeValueAsString(servType);
				writer.write(payload);
				resp.setStatus(200);
			} catch (StreamReadException | DatabindException e) {
				resp.setStatus(400);
			}
			break;
		default:
			List<Service_Types> servList = service_TypesService.getAllService_Types();
			String payload = mapper.writeValueAsString(servList.toString().toString());
			writer.write(payload);
			resp.setStatus(200);
			break;
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Service_Types servType = mapper.readValue(req.getInputStream(), Service_Types.class);
			service_TypesService.updateService_Types(servType);
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
			String idParam = req.getParameter("servTypeId");
			if (idParam == null) {
				resp.setStatus(400);
				writer.write("Please include the query ?servTypeId=# in your url");
				return;
			}

			int servTypeId = Integer.valueOf(idParam);

			boolean delete = service_TypesService.deleteServce_Types(servTypeId);
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
