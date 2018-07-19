<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Product Details</title>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
	
<link rel="stylesheet" href="./css/defaultStyle.css">

<style type="text/css">
.addToCartButton {
	background-color: #333;
	border: none;
	color: white;
	padding: 15px 32px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
}

.addToCartButton:hover {
	background-color: #1e90ff; 
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
				<a href="electronicsPage.jsp">Electronics</a> 
				<a href="clothingPage.jsp">Clothing</a> 
				<a href="booksPage.jsp">Books</a>
				<a href="autoPage.jsp">Automotive</a> 
				<a href="homePage.jsp">Home</a> 
				<a href="viewAllPage.jsp">View All</a>
			</div>
		</div>

		<a href="cartPage.jsp">Cart</a> <a href="inventoryPage.jsp">Inventory</a>
		<a href="loginPage.jsp" style="float: right">Sign In</a>

		<!-- Search Bar -->
		<div class="search-container">
			<form name="searchBar" action="searchResponseServlet"
				onsubmit="return validateForm()" method="POST">
				<input type="text" name="value" placeholder="Search">
				<button type="submit">
					<i class="fa fa-search"></i>
				</button>
			</form>
		</div>
	</div>

	<!-- Inventory page below nav bar -->
	<div class="row">
		<div class="rightcolumn">
			<div class="card">
			<h4> <a href="javascript:history.back()"> < Back to product listings</a> </h4>
				
				
				<div class="first-column">	
				<br>
				<br>			
				<div><img src="./productImages/
					${itemName}.jpg" align="right" style="width: 300px" alt="product"></div> 
				</div>

				<div class="second-column">
				
				<br>
				<h2>${itemName}</h2>
				
				<hr>
				<br>
				<br>
				<p>${itemDescription}</p>
				<br>
				<br>
				<br>
				<p>$${itemPrice}</p>
				
				<form name="itemForm" action="AddtoCartServlet" method="POST">
				<select name="numberOfItem" style="width: 70px;">
									<option value="1">1</option>
									<option value="2">2</option>
									<option value="3">3</option>
									<option value="4">4</option>
									<option value="5">5</option>
									<option value="6">6</option>
									<option value="7">7</option>
									<option value="8">8</option>
									<option value="9">9</option>
									<option value="10">10</option>
				</select>
								

								
				<br>
				<br>
				<br>
					
				<input type="hidden" name="itemID" value="${itemID}">
				</form>
				<a href="#" onclick="document.itemForm.submit();document.body.style.cursor='wait';return true;">
				<button type="button" class="addToCartButton">Add To Cart</button></a>				
					
										
				</div>
				
			</div>
			<!-- end divider for card  -->

		</div>
		<!-- End row divider  -->
	</div>
	
		<div class="footer">
		<h2>
			<a href="contactUsPage.jsp"><font color="000000">Contact Us</font></a>
		</h2>
	</div>
</body>
</html>