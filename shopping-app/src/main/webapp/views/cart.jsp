<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/myjsptags.tld" prefix="cart" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cart</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/css/index.css">
<link rel="stylesheet" href="/css/home.css">
<link rel="stylesheet" href="/css/cart.css">
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
        	<a href="/home">
	            <img src="/images/circle.png" alt="tabs">
	            <span id="totalItem" class="badge">${totalItems}</span>
            </a>
        </div>
	</nav>
	<main>
		<div></div>
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
	       <!--  <div class="mainCart" >
	                <div class="cartItem">
	                    <p class="cartItemName"> <button class="delete" ><i class="fa fa-times"></i></button><span>Mushroom</span></p>
	                    <p> <span class="headingToHide">Rate- </span> 250/kg</p>
	                    <input type="number" class="product-quantity-box" value="3.5">
	                        
	                    </div>
	                    <p><span class="headingToHide">Price- </span> 500</p>
	                </div>
	        </div> -->
	        <!-- <div class="alert">
	            <p>Cart is empty</p>
	            <p>Please add item in the cart</p>
	        </div> -->
       
	        <!-- <div class="totalPrice" style="margin-top:10px;">
	            <p></p>
	            <p> Total:</p>
	            <p>2576</p>
	        </div>
	       <div class="totalPrice">
	            <p></p>
	            <p style="color:green" class="discountedPrice">Tax:</p>
	            <p style="color:green" class="discountedPrice">+15.85</p>
	        </div>
	        <div class="totalPrice">
	            <p></p>
	            <p class="discountedPrice"> Discount:</p>
	            <p class="discountedPrice">-589</p>
	        </div>

	        <div class="totalPrice grandTotal">
	            <p></p>
	            <p>Grand Total</p>
	            <p>765754</p>
	        </div>
        	<button class="continueBtn" >Continue</button> -->
    	</div>
		

	</main>
	<%@ include file="footer.jsp"%> 
	<aside id="menuBar">
		<p class="menuBarHome"><a href="/home"><i class="fa fa-home"></i>Home</a></p>
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
		<p>Cart Updated</p>
	</div>
<script src="/js/common.js"></script>
</body>
</html>