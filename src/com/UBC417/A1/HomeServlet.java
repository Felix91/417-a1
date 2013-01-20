package com.UBC417.A1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.UBC417.A1.Data.Flight;

@SuppressWarnings("serial")
public class HomeServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		//Get all flights in datastore
		req.setAttribute("flights", Flight.GetFlights());
		
		//redirect to index.jsp
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/index.jsp");
		rd.forward(req, resp);
	}

}
