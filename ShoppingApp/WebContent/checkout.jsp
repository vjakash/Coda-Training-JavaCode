<%@page import="java.util.List"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Checkout Page....</h1>
<%@ include file="logout.jsp" %>
<%
	Map<String,ArrayList<Float>> cart=(Map<String,ArrayList<Float>>)session.getAttribute("cart");
	Set<Map.Entry<String,ArrayList<Float>>> cartPair=cart.entrySet();
	request.setAttribute("itemList", cartPair);
%>
    <h1>Delivery Details</h1>
	<p ><span style="font-size:1.1em;">${ deliveryAddress.get("name")}</span><br>
	${deliveryAddress.get("doorno")},${ deliveryAddress.get("street") }<br>
	${deliveryAddress.get("area")},<br>
	${deliveryAddress.get("city")}-${deliveryAddress.get("pincode")}</p>
	<form action="checkout.do;jsessionid=<%=session.getId()%>">
		<input type="hidden" name="formid" value="checkout"/>
		<input type="submit" value="Place order"/>
	</form>
	
<h1>Items</h1>
<table border="1" style="width:100%;">
	<tr >
		<th>Item Name</th>
		<th>Quantity</th>
		<th>Item Price</th>
		<th>Total</th>
	</tr>
	<c:forEach items="${itemList}" var="item">
   		<tr >
		<th>${ item.getKey()}</th>
		<th>${ item.getValue().get(0)}</th>
		<th>${ item.getValue().get(1)}</th>
		<th>${Math.round((item.getValue().get(0) * item.getValue().get(1))*100.0)/100.0}</th>
		</tr>
	</c:forEach>
	<%-- <%
		for(Map.Entry<String,ArrayList<Float>> pair:cart.entrySet()){
	%>
	<tr >
		<th><%=pair.getKey() %></th>
		<th><%=pair.getValue().get(0) %></th>
		<th><%=pair.getValue().get(1) %></th>
		<th><%=pair.getValue().get(0)*pair.getValue().get(1) %></th>
		</tr>
	<%
		}
	%> --%>
	
</table>
</body>
</html>