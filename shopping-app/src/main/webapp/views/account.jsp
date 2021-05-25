<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="Form" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Account</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/css/index.css">
<link rel="stylesheet" href="/css/home.css">
<link rel="stylesheet" href="/css/account.css">
</head>
<body>
<nav>
        <button class="hamburger hamburger--spin" id="hamburger" type="button"  onClick="openLeftMenu()">
            <span class="hamburger-box">
                <span class="hamburger-inner"></span>
            </span>
        </button>
        <div class="logo"   style="outline: 0;">
            <span>Fresh Basket</span>
        </div>

        <div class="circle" style="cursor: pointer;outline: 0;">
           <a href="/cart">
           	 <img src="/images/circle.png" alt="tabs">
           	 <span id="totalItem" class="badge">${totalItems}</span>
            </a>
        </div>
	</nav>
	<main>

		<div class="topContainer">
			<div class="infoContainer">
				<p class="infoTitle">Account Info</p>
				<Form:form method="post" action="updateUserInfo" modelAttribute="user">
					<div class="infoInpWrapper">
						<label>Username</label>
						<Form:input path="username"/>
					</div>
					<div class="infoInpWrapper">
						<label>Password</label>
						<Form:input path="password"/>
					</div>
					
					<div class="infoInpWrapper">
						<label>Mobile Number</label>
						<Form:input path="mobile"/>
					</div>
					
					<div class="infoInpWrapper">
						<label>Email</label>
						<Form:input path="email"/>
					</div>
					<div class="errorDiv">
						<p style="color:green;">${succesMsg}</p>
						<Form:errors path="username"/><br/>
						<Form:errors path="password"/><br/>
						<Form:errors path="mobile"/><br/>
						<Form:errors path="email"/>
					</div>
					<input class="updateInfoBtn" type="submit" value="Update Info"/>
				</Form:form>
			</div>
			<div class="newAddressContainer">
				<p class="infoTitle">New Address</p>
				<Form:form method="post" action="saveAddress" modelAttribute="address">
					<div class="infoInpWrapper">
						<label>Name</label>
						<Form:input path="name" placeholder="Ex: Home or Office"/>
					</div>
					<div class="infoInpWrapper">
						<label>doorno</label>
						<Form:input path="doorno"/>
					</div>
					
					<div class="infoInpWrapper">
						<label>Street</label>
						<Form:input path="street"/>
					</div>
					
					<div class="infoInpWrapper">
						<label>Area</label>
						<Form:input path="area"/>
					</div>
					<div class="infoInpWrapper">
						<label>City</label>
						<Form:input path="city"/>
					</div>
					
					<div class="infoInpWrapper">
						<label>Pincode</label>
						<Form:input path="pincode"/>
					</div>
					<div class="errorDiv">
						<Form:errors path="name"/>&nbsp;&nbsp;&nbsp;
						<Form:errors path="doorno"/>&nbsp;&nbsp;&nbsp;
						<Form:errors path="street"/><br/>
						<Form:errors path="area"/>&nbsp;&nbsp;&nbsp;
						<Form:errors path="city"/>&nbsp;&nbsp;&nbsp;
						<Form:errors path="pincode"/>
					</div>
					<input class="updateInfoBtn" type="submit" value="Save Address"/>
				</Form:form>
			</div>
		</div>
		<div class="bottomContainer">
			<p>Saved Addresses</p>
			<div class="addressList">
				<c:forEach items="${ addresses }" var="address"> 
				  <div class="address">
						<p><button class="delete" onclick="deleteAddress(event,${address.addressId})" ><i class="fa fa-times"></i></button>&nbsp;${ address.name }</p>
						<address>
							${ address.doorno },${ address.street },
							${ address.area },<br>
							${ address.city }-${ address.pincode }
						</address>
					</div>
				</c:forEach>
			</div>
		</div>
	</main>
	<%@ include file="footer.jsp"%>
	<aside id="menuBar">
		<p class="menuBarHome"><a href="/home"><i class="fa fa-home"></i><i class="fab fa-mobile-alt"></i> Home</a></p>
		<p class="menuBarHeading">categories</p>
		<ul class="menuBarcategories">
			<li><a href="/category/vegetables">Vegetables</a></li>
			<li><a href="/category/fruits">Fruits</a></li>
			<li><a href="/category/groceries">Groceries</a></li>
		</ul>
		<p><a href="/account">Account</a></p>
		<p><a href="/logout">Logout</a></p>
	</aside>
	
	<div id="toast" class="toast">
		<p>Details Updated</p>
	</div>
<script src="/js/common.js"></script>
</body>
</html>