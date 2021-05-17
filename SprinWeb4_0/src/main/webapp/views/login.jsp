<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="spring" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<spring:form method="post" action="submitform" commandName="loginForm">
	
		UserName:<spring:input path="uname"/>
		<spring:errors path="uname"/><br/>
		PassWord:<spring:password path="upass"/>
		<spring:errors path="upass"/><br/>
		
		<input type="submit" value="login..">
	</spring:form>
</body>
</html>