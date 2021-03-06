<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.controller.CartHandler"
	import="application.model.Cart" import="com.controller.CustomerHandler" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Shopping Cart</title>
<link rel="stylesheet" type="text/css" href="./css/styles.css">
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

/* Right column */
.rightcolumn {
	float: right;
	width: 100%;
}

/* Fake image */
.fakeimg {
	background-color: #aaa;
	width: 100%;
	padding: 20px;
}

/* Add a card effect for articles */
.card {
	background-color: white;
	padding: 20px;
	margin-top: 20px;
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

<!-- Grid-Row styling for products -->
<style type="text/css">
.grid-container {
	display: grid;
	grid-template-columns: auto auto auto auto;
	grid-gap: 10x;
	background-color: #000000;
	padding: 0px; /*Outline  */
}

.grid-container>div {
	background-color: rgba(255, 255, 255, 0.8);
	text-align: center;
	padding: 20px 0;
	font-size: 17px;
}

.item1 {
	grid-row: 1/span 2;
}
</style>


<!-- Scripts that validate the cart and give the cart page a waiting cursor  -->
<script type="text/javascript">

	function clearWait(){
		document.body.style.cursor='wait;'
		
		window.onload=function(){document.body.style.cursor='default';}
	}
	
	function validateCart() {
		var table = document.getElementById('cart').getElementsByTagName('tr');
		var tableRows = table.length;
			if(tableRows < 5){
				document.getElementById('submitbtn').style.visibility = 'hidden';
			} else {
				document.getElementById('submitbtn').style.visibility = 'visible';
		}
	}
	
	function startUp(){
		clearWait();
		validateCart();
	}
</script>

</head>
<body onload= "startUp()">

	<div class="header">
		<img src="./Images/siteLogo.jpeg" style="height: 300px;" alt="">
	</div>

	<!-- Navigation bar on the top of the menu  -->
	<div class="topnav">
		<a href="./registeredCustomerViews/signedInCusWebsite.jsp">Home</a>

		<!-- Drop down sub menu for categories in navigation bar  -->
		<div class="dropdown">
			<button class="dropbtn">
				Categories <i class="fa fa-caret-down"></i>
			</button>
			<div class="dropdown-content">
				<a href="./registeredCustomerViews/customElectronics.jsp">Electronics</a> 
				<a href="./registeredCustomerViews/customClothing.jsp">Clothing</a> 
				<a href="./registeredCustomerViews/customBooks.jsp">Books</a>
				<a href="./registeredCustomerViews/customAuto.jsp">Automotive</a> 
				<a href="./registeredCustomerViews/customHome.jsp">Home</a> 
				<a href="./registeredCustomerViews/customViewAll.jsp">View All</a>
			</div>
		</div>

		<a href="./registeredCustomerViews/customCart.jsp" class="active">Cart</a> <a href="./registeredCustomerViews/customInventory.jsp">Inventory</a>
		<a href="./LogOutServlet" style="float: right" name="signOutLink">Sign Out</a>

		<!-- Search Bar -->
		<div class="search-container">
			<form name="searchBar" action="./customSearchResponseServlet"
				onsubmit="return validateForm()" method="post">
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
				<div id="w">
				
					<%
						//CustomerHandler handler = new CustomerHandler();

						CartHandler cartHandler = new CartHandler();
						String cusID = (String)request.getSession().getAttribute("cusID");
					
						Cart cart = cartHandler.getCartbyCustomerIdtwo(cusID);
						
						String cusName = (String)request.getSession().getAttribute("cusName");
												
						String cartID = cart.getCartId();
						
						request.getSession().setAttribute("cartID", cartID);

									
					%>
					<header id="title">
					<h1><%out.println(cusName+"'s ");%>Shopping Cart</h1>
					</header>
					
					<% 
					for (int k = 0; k < cart.getSize(); k++) {
					
					
					out.println("<form name=\"removeItemForm"+k+"\" action=\"./customRemove2Servlet\" method=\"POST\">");
					out.println("<input type=\"hidden\" name=\"itemID\" value=\""+cart.getCartItems().get(k).getItemId()+"\">");
					out.println("</form>");
					
					}
					
					%>
					<div id="page">
						<table id="cart">
							<thead>
								<tr>
									<th class="first"></th>
									<th class="second">Qty</th>
									<th class="third">Product</th>
									<th class="fourth">Total</th>
									<th class="fifth">&nbsp;</th>
								</tr>
							</thead>
							<tbody>

								<!-- shopping cart contents -->

								<!-- JSP Scriplet that generates the contents -->

								<%
									for (int i = 0; i < cart.getSize(); i++) {

										out.println("<tr class=\"productItem\">");

										//Picture
										out.println("<td><img src=\"./productImages/"
										+ cart.getCartItems().get(i).getItemName() + ".jpg\" class=\"thumb\" " 
										+ "style=\"width: 140px\" alt=\"product\"></a></td>");

										// Quantity
										out.println("<td><input type=\"number\" value=\"" + cart.getCartItems().get(i).getQuantity()
												+ "\" min=\"0\" max=\"99\"class=\"qtyinput\"></td>");

										//Name
										out.println("<td>");
										out.println(cart.getCartItems().get(i).getItemName());
										out.println("</td>");

										//Total Item Price
										out.println("<td>");
										out.println("$" + cart.getItemTotal(cart.getCartItems().get(i)));
										out.println("</td>");

										// Remove option 
										out.println("<td>");
										out.println("<span class=\"remove\" onclick=\"document.removeItemForm"+i+".submit()\"><img src=\"./Images/trash.png\" alt=\"X\"></span>");
										out.println("</td>");
										out.println("</tr>");
									}
								%>

								<!-- tax + subtotal -->
								<tr class="extracosts">
									<td class="light">Shipping:</td>
									<td colspan="2" class="light"></td>
									<td>Free</td>
									<td>&nbsp;</td>
								</tr>
								<tr class="totalprice">
									<td class="light">Total:</td>
									<td colspan="2">&nbsp;</td>
									<td colspan="2"><span class="thick"> 
									<%
 										out.println(cart.getCartTotal());
 									%>
									</span></td>
								</tr>
								<!-- checkout btn -->
								<tr class="checkoutrow">
								<td colspan="5" class="checkout"><a href="./registeredCustomerViews/customPersonalInfo.jsp">
								<button id="submitbtn">Checkout</button></a>
								</td>								
								</tr>
							</tbody>
						</table>
					</div>

					<!-- Script for if there are no items to hide checkout button  -->
					<script type="text/javascript">
							function validateCart() {
								var table = document.getElementById('cart').getElementsByTagName('tr');
								var tableRows = table.length;
								if(tableRows < 5){
									document.getElementById('submitbtn').style.visibility = 'hidden';
								} else {
									document.getElementById('submitbtn').style.visibility = 'visible';
								}
							}
					</script>

				</div>
				<!-- end divider for shopping cart  -->

			</div>
			<!-- end divider for card  -->

		</div>
		<!-- End row divider  -->
	</div>


	<div class="footer">
		<h2>
			<a href="./registeredCustomerViews/customContact.jsp"><font color="000000">Contact
					Us</font></a>
		</h2>
	</div>
</body>
</html>
