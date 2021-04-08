<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Invoice Page....</h1>
<%@ include file="logout.jsp" %>
<%
	/* Map<String,ArrayList<Float>> cart=(Map<String, ArrayList<Float>>) session.getAttribute("cart"); */
	Map<String,ArrayList<Float>> cart=(Map<String,ArrayList<Float>>)session.getAttribute("cart");
	System.out.println(cart);
%>
<h1>Enter Delivery Details:</h1>
	<form>
		<input type="hidden" name="formid" value="deliveryadd" required>
		Full Name:<input type="text" name="name" required/>
		Email-id:<input type="email" name="email" required/>
		Door No:<input type="text" name="doorno" required/>
		Street:<input type="text" name="street" required/>
		Area:<<input type="text" name="area" required/>
		City:<input type="text" name="city" required/>
		Pincode:<input type="text" name="pincode" required/>
		<input type="submit" value="Proceed">
	</form>
</body>
</html>