<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="lang.do;jsessionid=<%=session.getId()%>">
		<input type="hidden" name="formid" value="lang">
		<select name="language">
			<option value="ta">Tamil</option>
			<option value="te">Telugu</option>
			<option value="hi">Hindi</option>
		</select>
		<input type="submit"/>
	</form>
</body>
</html>