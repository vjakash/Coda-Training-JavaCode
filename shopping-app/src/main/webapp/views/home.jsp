<%@page import="com.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="/WEB-INF/myjsptags.tld" prefix="shop" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Fresh basket</title>
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
            <img src="/images/circle.png" alt="tabs">
        </div>
	</nav>
	<main>
		<div id="banner">
			<div class="banner-btn left" onClick="changeBanner('left')">
            	<button> &lt; </button>
	        </div>
	        <div class="banner-btn right" onClick="changeBanner('right')">
            	<button> &gt;</button>
        	</div>
		</div>
		
		
		<div class="productContainer">
			<div class="category">
				<p class="categoryName">Vegetables</p>
				<shop:getItems type="vegetables" noOfItems="4"/>
			</div>
			<div class="category">
				<p class="categoryName">Fruits</p>
				<shop:getItems type="fruits" noOfItems="4"/>
			</div>
			<div class="category">
				<p class="categoryName">Vegetables</p>
				
			</div>
		</div>
	</main>
	<%@ include file="footer.jsp"%>
<script src="/js/home.js"></script>
	<aside id="menuBar">
	
	</aside>
</body>
</html>
					