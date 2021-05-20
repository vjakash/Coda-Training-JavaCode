<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="Form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Register</title>
<link rel="stylesheet" href="/css/index.css">
<link rel="stylesheet" href="/css/register.css">
</head>
<body>

	<header>
		<p>Fresh Basket</p>
	</header>
	<main>
	
		<div class="form">
				<p class="title">Register</p>
				<div class="registerVector">
					<img src="/images/customerregister.svg"/>
				</div>
				<p class="loginPhrase">Already have an account? <a class="signin" href="/" >Sign in</a></p>
				
			<Form:form class="inputContainer" method="post" action="submitRegister" modelAttribute="user">
			
				<div class="inputWrapper">
					<label>Username<span style="color:red">${usernameError}</span></label><br>
					<Form:input path="username"/>
				</div>
				<div class="inputWrapper">
					<label>Password</label><br>
					<Form:password path="password"/>
				</div>
				<div class="inputWrapper">
					<label>Mobile number</label><br>
					<Form:input path="mobile"/>
				</div>
				<div class="inputWrapper">
					<label>Email</label><br>
					<Form:input path="email"/>
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
					<input type="submit" value="Register">
				</div>
				<div class="errorDiv">
					<Form:errors path="username"/><br/>
					<Form:errors path="password"/><br/>
					<Form:errors path="mobile"/><br/>
					<Form:errors path="email"/>
				</div>
			</Form:form>
		</div>
		
	</main>
	
</body>
</html>