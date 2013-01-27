<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.util.*"  %>
    <%@ page import="com.UBC417.A1.Data.Flight" %>
    <%@ page import="com.google.appengine.api.datastore.Entity" %>
    <%@ page import="com.UBC417.A1.Data.Seat" %>
    <%@ page import="com.google.appengine.api.datastore.KeyFactory" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Home</title>
<link href="Site.css" rel="Stylesheet" type="text/css"/>
</head>
<body>
	
	
	<div class="wrapper">
		<div id="Content">
			<div id="Header"><H1>Flights - V1</H1></div>
			<hr/>
			<div id="MainContent">

				<% Iterable<Entity> list = (Iterable<Entity>)request.getAttribute("flights"); %>
					
				<ul>
				<% for( Entity e : list ) { %>
					<li>
						Flight : <%=e.getKey().getName() %>
						
						<%Iterable<Entity> seats = Seat.GetFreeSeats(e.getKey()); %>
						<ul>
						<%for(Entity s : seats) { %>
							<li>
								<a href="/ReserveSeat?FlightName=<%=KeyFactory.keyToString( e.getKey() ) %>&SeatID=<%=s.getKey().getName() %>">
									Seat : <%=s.getProperty("SeatID") %></a>
							</li>
						<%}%>
						</ul>
					</li>
				<%} %>
				</ul>
				
			</div><!-- end MainContent -->
		</div><!-- end Content -->
	</div><!-- end wrapper -->
</body>
</html>