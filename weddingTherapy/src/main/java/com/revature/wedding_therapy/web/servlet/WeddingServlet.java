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
import com.revature.wedding_therapy.models.Weddings;
import com.revature.wedding_therapy.services.WeddingService;

public class WeddingServlet extends HttpServlet {

	ObjectMapper mapper;
	WeddingService weddingService;

	public WeddingServlet(ObjectMapper mapper, WeddingService weddingService) {
		this.mapper = mapper;
		this.weddingService = weddingService;
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("application/json");
		try {
			Weddings newWedding = mapper.readValue(req.getInputStream(), Weddings.class);
			boolean wasReg = weddingService.createNewWedding(newWedding);

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
		// Switch statements are back sorry
		PrintWriter writer = resp.getWriter();
		// Obtains everything after the /directors
		String path = req.getPathInfo();
		if (path == null)
			path = "";
		switch (path) {
		case "/ID":
			try {
				String idParam = req.getParameter("weddingId");
				if (idParam == null) {
					resp.setStatus(400);
					writer.write("Please include the query ?weddingId=# in your url");
					return;
				}

				int weddingId = Integer.valueOf(idParam);

				Weddings wedding = weddingService.getWedding(weddingId);
				if (wedding == null) {
					resp.setStatus(500);
					return;
				}
				String payload = mapper.writeValueAsString(wedding);
				writer.write(payload);
				resp.setStatus(200);
			} catch (StreamReadException | DatabindException e) {
				resp.setStatus(400);
			}
			break;
		default:
			List<Weddings> weds = weddingService.findAllWeddings();
			String payload = mapper.writeValueAsString(weds.toString().toString());
			writer.write(payload);
			resp.setStatus(200);
			break;
		}
	}

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			Weddings wedding = mapper.readValue(req.getInputStream(), Weddings.class);
			weddingService.updateWedding(wedding);
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
			//System.out.println("\nWeddingServlet:doDelete\n");
			PrintWriter writer = resp.getWriter();
			String idParam = req.getParameter("weddingId");
			if (idParam == null) {
				resp.setStatus(400);
				writer.write("Please include the query ?weddingId=# in your url");
				return;
			}

			int weddingId = Integer.valueOf(idParam);

			boolean delete = weddingService.deleteWedding(weddingId);
			if (delete) {
				resp.setStatus(200);
				return;
			}
			else {
				String payload = mapper.writeValueAsString("Deletion Failed");
				writer.write(payload);
				resp.setStatus(304);
				return;
			}
		} catch (StreamReadException | DatabindException e) {
			resp.setStatus(400);
		}
	}

}
