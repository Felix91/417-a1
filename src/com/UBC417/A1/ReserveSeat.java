package com.UBC417.A1;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.UBC417.A1.Data.Seat;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.EntityNotFoundException;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;

@SuppressWarnings("serial")
public class ReserveSeat extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		// Redirect to reserveSeat.jsp
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/reserveSeat.jsp");
		rd.forward(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		// Get parameters
		Key FlightKey = KeyFactory.stringToKey(req.getParameter("FlightName"));
		String SeatID = req.getParameter("SeatID");
		String FirstName = req.getParameter("FirstName");
		String LastName = req.getParameter("LastName");

		String forwardTo = "/seatConfirmation.jsp";
		try {
			if (!Seat.ReserveSeat(FlightKey, SeatID, FirstName, LastName)) {
				// seat not reserved, show error page
				forwardTo = "/ReserveSeatError.jsp";
			}
		} catch (EntityNotFoundException e) {
			// seat not found, show error page
			forwardTo = "/ReserveSeatError.jsp";
		}

		// redirect to final page
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher(forwardTo);
		rd.forward(req, resp);
	}
}
