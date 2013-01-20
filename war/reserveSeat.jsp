<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reserve Seat</title>
<link href="Site.css" rel="Stylesheet" type="text/css"/>
</head>
<body>

<div class="wrapper">
	<div id="Content">
		<div id="Header"><H1>Reserve Seat : <%=request.getParameter("SeatID") %></H1></div>
		<hr/>
		<div id="MainContent">	
			<form action="ReserveSeat" method="post">
				<input type="hidden" name="FlightName" value="<%=request.getParameter("FlightName")%>"/>
				<input type="hidden" name="SeatID" value="<%=request.getParameter("SeatID") %>"/>
				
				<table>
				<tr>
					<td align="right">First Name:</td>
					<td align="left"><input type="text" name="FirstName"/></td>
				</tr>
				<tr>
					<td align="right">Last Name:</td>
					<td align="left"><input type="text" name="LastName"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Reserve Seat"/></td>
				</tr>
				</table>
			</form>
		</div><!-- end MainContent -->
	</div><!-- end Content -->
</div><!-- end wrapper -->

</body>
</html>