package com.UBC417.A1.Helpers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.UBC417.A1.Data.Flight;
import com.UBC417.A1.Data.Seat;
import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

@SuppressWarnings("serial")
public class PrepServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		List<Entity> l = new ArrayList<Entity>();

		// Create Flight F2491
		Entity e = Flight.CreateFlight("F2491", false);
		// put flight into datastore
		ds.put(e);

		// Create seats for flight
		for (int i = 1; i < 50; i++) {
			for (int c = 'A'; c <= 'D'; c += 1) {
				l.add(Seat.CreateSeat(String.format("%d%c", i, c), e.getKey().getName(),
						false));
			}
		}

		// put all seats into datastore
		ds.put(l);

		// redirect to prepDone.jsp
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/prepDone.jsp");
		rd.forward(req, resp);
	}
}
