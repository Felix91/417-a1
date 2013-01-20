<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seat Reservation Error</title>
<link href="Site.css" rel="Stylesheet" type="text/css"/>
</head>
<body>
	
 <div class="wrapper">
	<div id="Content">
		<div id="Header"><H1>Unable to Reserve Seat : <%=request.getParameter("SeatID") %></H1></div>
		<hr/>
		<div id="MainContent">
			The seat you requested could not be reserved, please <a href="/">try again.</a>
		</div><!-- end MainContent -->
	</div><!-- end Content -->
</div><!-- end wrapper -->
</body>
</html>