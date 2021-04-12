<!DOCTYPE html>
<%@page import="org.apache.poi.util.SystemOutLogger"%>
<%@page import="java.util.ResourceBundle" buffer="8kb" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="login.do;jsessionid=<%=session.getId()%>" method="post">
<%-- 	<%
		ResourceBundle rb=(ResourceBundle)session.getAttribute("rb");
	%> --%>
	<input type="hidden" name="formid" value="login">
		${rb.getString("username")}:<input type="text" name="uname" placeholder="vijay" required>
		${ rb.getString("password")}:<input type="password" name="upass" placeholder="abcd" required> 
		
		<input type="submit" value="Login..">
	</form>
</body>
</html>