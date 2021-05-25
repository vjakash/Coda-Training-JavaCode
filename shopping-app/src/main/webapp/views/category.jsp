<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.springframework.boot.web.servlet.server.Session"%>
<%@ taglib uri="/WEB-INF/myjsptags.tld" prefix="shop" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Category-${type}</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="/css/index.css">
<link rel="stylesheet" href="/css/home.css">
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
		
		<div class="productContainer">
			<div class="category">
				<p class="categoryName">${type}</p>
				<shop:getItems type="${ type }" noOfItems="*"/>
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
		<p>Cart Updated</p>
	</div>
<script src="/js/common.js"></script>
</body>
</html>