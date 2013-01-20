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

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.Query;

@SuppressWarnings("serial")
public class DeleteAll extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException, ServletException {

		
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();

		//Deletes all seats in datastore
		Query q = new Query("Seat").setKeysOnly();

		Iterable<Entity> seats = ds.prepare(q).asIterable();
		List<Key> keys = new ArrayList<Key>();
		for( Entity e : seats)
			keys.add(e.getKey());
		
		ds.delete(keys);

		//Deletes all flights in datastore
		q = new Query("Flight");
		seats = ds.prepare(q).asIterable();
		keys.clear();
		for( Entity e : seats)
			keys.add(e.getKey());
		
		ds.delete(keys);
		
		//redirect to deleteComplete.jsp
		ServletContext sc = getServletContext();
		RequestDispatcher rd = sc.getRequestDispatcher("/deleteComplete.jsp");
		rd.forward(req, resp);
	}
}
