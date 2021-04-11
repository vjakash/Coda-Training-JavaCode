<!DOCTYPE html>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Map"%>
<%@page import="daopack.ItemDTO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Properties"%>
<%@page import="daopack.ItemMasterDAOImpl"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/myjsptags.tld" prefix="shop" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Grocery Shop</h1>
<%@ include file="logout.jsp" %>
	<form action="shop.do" method="post">
	<input type="hidden" name="formid" value="shop">
	<input type="hidden" name="shopid" value="shop3">
	<%-- <%
			Map<String,ArrayList<Float>> cart=(Map<String,ArrayList<Float>>)session.getAttribute("cart");
	if(cart==null) {
		cart=new HashMap<String, ArrayList<Float>>();
	}
		 	ItemMasterDAOImpl itemMasterDAOImpl=ItemMasterDAOImpl.getItemMasterDaoImpl((Properties)request.getServletContext().getAttribute("dbConfigProp"));
			List<ItemDTO> itemList=itemMasterDAOImpl.findAllByType("groceries");
			for(int i=0;i<itemList.size();i++){
		%>
			<%= itemList.get(i).getItem_name() %>:<input type="checkbox" name=<%=itemList.get(i).getItem_name() %> value="<%=itemList.get(i).getPrice() %>" <%=cart.get(itemList.get(i).getItem_name())!=null?"checked":null %>/> 
			<p>Price:<%=itemList.get(i).getPrice() %>/<%=itemList.get(i).getItem_unit() %></p>
	   <%
		}
	   %> --%>
	   <shop:getItems type="groceries"/>
		<!-- Rice:<input type="checkbox" name="c7" value="rice">
		Daal:<input type="checkbox" name="c8" value="daal">
		Oil:<input type="checkbox" name="c9" value="oil"> -->
		
		<input type="submit" value="Next shop..">
	</form>
</body>
</html>