<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="author" content="Erwin Herrera">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<style type="text/css">
* {
	box-sizing: border-box;
}

body {
	font-family: Arial;
	padding: 10px;
	background: #f1f1f1;
}

/* Create three equal columns that floats next to each other */
.column {
	float: left;
	width: 33.33%;
	padding: 10px;
	height: 425px; /* Should be removed. Only for demonstration */
}

/* Header/Blog Title */
.header {
	padding: 30px;
	text-align: center;
	background: white;
}

.header h1 {
	font-size: 50px;
}

/* Style the top navigation bar */
.topnav, .dropbtn {
	overflow: hidden;
	background-color: #333;
}

/* Style the topnav links */
.topnav a {
	float: left;
	display: block;
	color: #f2f2f2;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
	font-size: 17px;
}

/* Change color on hover */
.topnav a:hover, .dropdown:hover {
	background-color: #ddd;
	color: black;
}

/* Style the "active" element to highlight the current page */
.topnav a.active {
	background-color: #4CAF50;
	color: white;
}

/* Styling for the dropdown menu in the navigation bar  */
.dropdown {
	float: left;
	overflow: hidden;
}

.dropdown .dropbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.dropdown-content {
	display: none;
	position: absolute;
	background-color: #f9f9f9;
	min-width: 160px;
	box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
	z-index: 1;
}

.dropdown-content a {
	float: none;
	color: black;
	padding: 12px 16px;
	text-decoration: none;
	display: block;
	text-align: left;
}

.dropdown-content a:hover {
	background-color: #ddd;
}

.dropdown:hover .dropdown-content {
	display: block;
}
/* Styling for dropdown in nav bar ends here*/
.topnav .search-container {
	float: right;
}

/* Style the search box inside the navigation bar */
.topnav input[type=text] {
	padding: 6px;
	border: none;
	margin-top: 8px;
	font-size: 16px;
}

.topnav .search-container button {
	float: right;
	padding: 6px 10px;
	margin-top: 8px;
	margin-right: 16px;
	background: #ddd;
	font-size: 18px;
	border: none;
	cursor: pointer;
}

.topnav .search-container button:hover {
	background: #ccc;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

/* Footer */
.footer {
	padding: 20px;
	text-align: center;
	background: #ddd;
	margin-top: 20px;
}

/* Responsive layout - when the screen is less than 800px wide, make the 
two columns stack on top of each other instead of next to each other */
@media screen and (max-width: 800px) {
	.leftcolumn, .rightcolumn {
		width: 100%;
		padding: 0;
	}
}

/* Responsive layout - when the screen is less than 400px wide, make the 
navigation links stack on top of each other instead of next to each other */
@media screen and (max-width: 400px) {
	.topnav .search-container {
		float: none;
	}
	.topnav a, .topnav input[type=text], .topnav .search-container button {
		float: none;
		display: block;
		text-align: left;
		width: 100%;
		margin: 0;
		padding: 14px;
	}
	.topnav input[type=text] {
		border: 1px solid #ccc;
	}
}
</style>

<!-- Script that validates there is input in the search bar  -->
<script type="text/javascript">
	function validateForm() {
		var x = document.forms["searchBar"]["value"].value;
		if (x == "") {
			/* Do nothing if search bar is empty  */
			return false;
		}
		return true;
	}
</script>

</head>
<body>

	<div class="header">
		<img src="./Images/siteLogo.jpeg" style="height: 300px;" alt="">
	</div>

	<!-- Navigation bar on the top of the menu  -->
	<div class="topnav">
		<a href="Website.html">Home</a>

		<!-- Drop down sub menu for categories in navigation bar  -->
		<div class="dropdown">
			<button class="dropbtn">
				Categories <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="#">Electronics</a> <a href="#">Clothing</a> <a href="#">Books</a>
				<a href="#">Automotive</a> <a href="#">Home</a> <a
					href="viewAllPage.jsp">View All</a>
			</div>
		</div>

		<a href="cartPage.jsp">Cart</a> <a href="inventoryPage.jsp">Inventory</a>
		<a href="sign-in-form.jsp" style="float: right">Sign In</a>

		<!-- Search Bar -->
		<div class="search-container">
			<form name="searchBar" action="search-response.jsp"
				onsubmit="return validateForm()" method="post">
				<input type="text" name="value" placeholder="Search">
				<button type="submit">
					<i class="fa fa-search"></i>
				</button>
			</form>
		</div>
	</div>


	<div class="row">
		<div class="column" style="background-color: #aaa;">
			<h2>Electronics</h2>
			<a href="#">
				<center>
					<img src="./Images/electronics.jpeg" style="width: 70%" alt="">
				</center>
			</a>
			<p>Some text..</p>
		</div>
		<div class="column" style="background-color: #bbb;">
			<h2>Clothing</h2>
			<a href="#">
				<center>
					<img src="./Images/clothing.jpeg" style="width: 70%" alt="">
				</center>
			</a>
			<p>Some text..</p>
		</div>
		<div class="column" style="background-color: #ccc;">
			<h2>Books</h2>
			<a href="#">
				<center>
					<img src="./Images/books.jpeg" style="width: 70%" alt="">
				</center>
			</a>
			<p>Some text..</p>
		</div>
		<div class="column" style="background-color: #ddd;">
			<h2>Automotive</h2>
			<a href="#">
				<center>
					<img src="./Images/automotive.jpeg" style="width: 70%" alt="">
				</center>
			</a>
			<p>Some text..</p>
		</div>
		<div class="column" style="background-color: #eee;">
			<h2>Home</h2>
			<a href="#">
				<center>
					<img src="./Images/home.jpeg" style="width: 70%" alt=""
						onclick="Website.html">
				</center>
			</a>
			<p>Some text..</p>
		</div>
		<div class="column" align="center" style="background-color: #ggg;">
			<h2>More Coming Soon!</h2>
			<p>Thank you for shopping with the Nile. We appreciate your
				business!</p>
		</div>
	</div>

</body>
</html>
