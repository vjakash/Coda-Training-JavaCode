<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="/WEB-INF/myjsptags.tld" prefix="cart" %>
       <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Checkout</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<link rel="stylesheet" href="/css/index.css">
<link rel="stylesheet" href="/css/home.css">
<link rel="stylesheet" href="/css/payment.css">
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
   		<div class="cart-wrapper">
		    <div class="cart-container">
			        <div class="title">
			            <p>Cart</p>
			        </div>
			        <div class="heading">
			            <p>Product</p>
			            <p>Rate</p>
			            <p>Quantity</p>
			            <p>Price</p>
			        </div>
			        <cart:getCartItems/> 
		    </div>
	   </div>
	    <div class="rightWrapper">
	        <div class="address-container">
	            <div class="title">
	                <p>Delivering to </p>
	            </div>
	            <div class="group">
	                <span class="subheading">Name: </span><span><c:out value="${deliveryAddress['name']}"/></span>
	            </div>
	            <div class="group">
	                <span class="subheading">Address:</span>
	                <span>
	                       <c:out value="${deliveryAddress['doorno']}"/>,<c:out value="${deliveryAddress['street']}"/>,
	                    <br/> <c:out value="${deliveryAddress['area']}"/>,
						<c:out value="${deliveryAddress['city']}"/>-<c:out value="${deliveryAddress['pincode']}"/>
	                <br/>
	                </span>
	            </div>
	        </div>
	        <div class="address-container delivery-container">
	            <div class="deliveryGroup">
	                <p>Amount payable</p>
	                <p id="grandTotal">${ grandTotal }</p>
	            </div>
	        </div>
	        <div class="pay">
	            <button id="payBtn" class="payBtn" >
	                <span >Pay now & place order</span>
	            </button>
	        </div>
	    </div>
		
		
	</main>
	<div id="overlayDiv" class="overlay display-none" onclick="stopPropagation(event)">
		<div class="loader">
		    <div></div>
		    <div></div>
		    <div></div>
		    <div></div>
		 </div>
	</div>
<script src="/js/payment.js"></script>
</body>
</html>