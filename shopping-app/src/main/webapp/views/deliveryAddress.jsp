<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        
  <%@ taglib uri="http://www.springframework.org/tags/form" prefix="Form" %>
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delivery Address</title>
<link rel="stylesheet" href="/css/index.css">
<link rel="stylesheet" href="/css/home.css">
<link rel="stylesheet" href="/css/deliveryAddress.css">

</head>
<body>
	<nav>
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
	
		<div class="container">
			<p>Delivery Address</p>
			<div class="savedAddressContainer">
				<select onchange="selectAddress(this.value);">
				<option value="">Select saved Address</option>
					<c:forEach items="${ addresses }" var="address"> 
						<option value="${ address.doorno },${ address.street },${ address.area },${ address.city },${ address.pincode }">${ address.name }</option>
					</c:forEach>
				</select>	
			</div>
			<p>or</p>
			<Form:form method="post" action="addDeliveryAddress" modelAttribute="address">
					<%-- <div class="infoInpWrapper">
						<label>Person Name</label>
						<Form:input path="name"/>
					</div> --%>
					<div class="infoInpWrapper">
						<label>doorno</label>
						<Form:input id="doorno" path="doorno"/>
					</div>
					
					<div class="infoInpWrapper">
						<label>Street</label>
						<Form:input id="street" path="street"/>
					</div>
					
					<div class="infoInpWrapper">
						<label>Area</label>
						<Form:input id="area" path="area"/>
					</div>
					<div class="infoInpWrapper">
						<label>City</label>
						<Form:input id="city" path="city"/>
					</div>
					
					<div class="infoInpWrapper">
						<label>Pincode</label>
						<Form:input id="pincode" path="pincode"/>
					</div>
					<div class="errorDiv">
						<%-- <Form:errors path="name"/>&nbsp;&nbsp;&nbsp; --%>
						<Form:errors path="doorno"/>&nbsp;&nbsp;&nbsp;
						<Form:errors path="street"/><br/>
						<Form:errors path="area"/>&nbsp;&nbsp;&nbsp;
						<Form:errors path="city"/>&nbsp;&nbsp;&nbsp;
						<Form:errors path="pincode"/>
					</div>
					<input class="updateInfoBtn" type="submit" value="Proceed to payment"/>
			</Form:form>
		</div>
		
	</main>
<script src="/js/deliveryAddress.js"></script>
</body>
</html>