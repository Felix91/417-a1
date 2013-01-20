package com.UBC417.A1.Data;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.Query;
import com.google.appengine.api.datastore.Query.FilterOperator;
import com.google.appengine.api.datastore.Transaction;

//Flight Helper class, used to create and get flights from Google Datastore
public class Flight {
	// Create a flight
	// @store = true when you want to commit entity to datastore
	// = false when you want to commit entity later, like in a batch operation.
	public static Entity CreateFlight(String Name, boolean store) {
		Entity e = new Entity("Flight", Name);

		if (store) {
			DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
			ds.put(e);
		}

		return e;
	}

	// Get all flights in the datastore
	public static Iterable<Entity> GetFlights() {
		DatastoreService ds = DatastoreServiceFactory.getDatastoreService();
		Query q = new Query("Flight");
		return ds.prepare(q).asIterable();
	}
}