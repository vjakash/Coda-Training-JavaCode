<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="Form" %>
<!DOCTYPE html>
<%-- ;jsessionid=<%=session.getId()%>
 --%><html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link rel="stylesheet" href="/css/index.css">
<link rel="stylesheet" href="/css/login.css">
</head>
<body>
<header>
		<p>Fresh Basket</p>
	</header>
	<main>
	
		<div class="form">
				<p class="title">Login</p>
				<div class="registerVector">
					<img src="/images/customersignin.svg"/>
				</div>
				<p class="loginPhrase">Don't have an account? <a class="signin" href="/register" >Sign up</a></p>
				
			<Form:form class="inputContainer" method="post" action="submitLogin" modelAttribute="loginForm">
			
				<div class="inputWrapper">
					<label>Username<span style="color:red;font-size:0.8em;">${usernameError}</span></label><br>
					<Form:input path="username"/>
				</div>
				<div class="inputWrapper">
					<label>Password<span style="color:red;font-size:0.8em;">${passwordError}</span></label><br>
					<Form:password path="password"/>
				</div>
				<%-- Username:<Form:input path="username"/><span>${usernameError}</span>
				<Form:errors path="username"/><br/>
				
				Password:<Form:password path="password"/>
				<Form:errors path="password"/><br/>
				
				Mobile number:<Form:input path="mobile"/>
				<Form:errors path="mobile"/><br/>
				
				Email:<Form:input path="email"/>
				<Form:errors path="email"/><br/> --%>
				<div class="submitDiv">
					<input type="submit" value="Login">
				</div>
				<div class="errorDiv">
					<Form:errors path="username"/><br/>
					<Form:errors path="password"/><br/>
				</div>
			</Form:form>
		</div>
		
	</main>
</body>
</html>