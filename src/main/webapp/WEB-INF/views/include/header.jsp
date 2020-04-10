<html>
	<head>
	    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	    <script src="https://code.jquery.com/jquery-3.4.1.js"></script>
        <script>
            $(document).ready(function(){
               // alert('JQuery is ready and integrated');
            });
        </script>
		<title>Contact App</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1" />
		<link rel="stylesheet" href="resources/assets/css/main.css" />
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
	</head>
	<body class="subpage">

		<!-- Header -->
			<header id="header">
				<div class="logo"><a href="/ContactApp">Contact <span>App</span></a></div>
				<a href="#menu">Menu</a>
			</header>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
		<!-- Nav -->
		<c:if test="${sessionScope.userId==null }">
		<!--  Not logged in -->
			<nav id="menu">
				<ul class="links">
					<li><a href="/ContactApp">Home</a></li>
					<li><a href="/ContactApp/login">Login</a></li>
					<li><a href="/ContactApp/register">Register</a></li>
					<li><a href="/ContactApp/about-us">About Us</a></li>
				</ul>
			</nav>
		 </c:if>
		 <c:if test="${sessionScope.userId!=null && sessionScope.role == 1}">
			<nav id="menu">
				<ul class="links">
					<li><a href="/ContactApp/admin-dashboard">Home</a></li>
					<li><a href="/ContactApp/ulist">User List</a></li>
					<li><a href="/ContactApp/logout">Log Out</a></li>
				</ul>
			</nav>
		 </c:if>
		 <c:if test="${sessionScope.userId!=null && sessionScope.role == 2}">
			<nav id="menu">
				<ul class="links">
					<li><a href="/ContactApp/user-dashboard">Home</a></li>
					<li><a href="/ContactApp/contact_form">Add Contact</a></li>
					<li><a href="/ContactApp/clist">Contact List</a></li>
					<li><a href="/ContactApp/logout">Log Out</a></li>
				</ul>
			</nav>
		 </c:if>
