<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="com.controller.CartHandler"
	import="application.model.Cart" import="com.controller.CustomerHandler" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Nile Shopping Service: Checkout</title>
<style type="text/css">
body {
	font-family: Arial;
	font-size: 17px;
	padding: 8px;
}

* {
	box-sizing: border-box;
}

.row {
	display: -ms-flexbox; /* IE10 */
	display: flex;
	-ms-flex-wrap: wrap; /* IE10 */
	flex-wrap: wrap;
	margin: 0 -16px;
}

.col-25 {
	-ms-flex: 25%; /* IE10 */
	flex: 25%;
}

.col-50 {
	-ms-flex: 50%; /* IE10 */
	flex: 50%;
}

.col-75 {
	-ms-flex: 75%; /* IE10 */
	flex: 75%;
}

.col-25, .col-50, .col-75 {
	padding: 0 16px;
}

.container {
	background-color: #f2f2f2;
	padding: 5px 20px 15px 20px;
	border: 1px solid lightgrey;
	border-radius: 3px;
}

input[type=text] {
	width: 100%;
	margin-bottom: 20px;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 3px;
}

label {
	margin-bottom: 10px;
	display: block;
}

.icon-container {
	margin-bottom: 20px;
	padding: 7px 0;
	font-size: 24px;
}

.btn {
	background-color: #4CAF50;
	color: white;
	padding: 12px;
	margin: 10px 0;
	border: none;
	width: 100%;
	border-radius: 3px;
	cursor: pointer;
	font-size: 17px;
}

.btn:hover {
	background-color: #45a049;
}

a {
	color: #2196F3;
}

hr {
	border: 1px solid lightgrey;
}

span.price {
	float: right;
	color: grey;
}

/* Responsive layout - when the screen is less than 800px wide, make the two columns 
stack on top of each other instead of next to each other (also change the direction - make the "cart" column go on top) */
@media ( max-width : 800px) {
	.row {
		flex-direction: column-reverse;
	}
	.col-25 {
		margin-bottom: 20px;
	}
}
</style>
</head>

<body>

	<h4> <a href="javascript:history.back()"> < Back to Personal Information</a> </h4>
	<h2>Checkout: Payment Method</h2>
	<div class="row">
		<div class="col-75">
			<div class="container">
				<form action="../customBillingCusInfoServlet" method="POST">

					<div class="row">
						<div class="col-50">
							<h3>Billing Address</h3>
							<label for="fname"><i class="fa fa-user"></i> Full Name</label> 
							<input type="text" id="fname" name="firstname" placeholder="Full Name" required> 
							<label for="adr"><i class="fa fa-address-card-o"></i> Address</label> 
							<input type="text" id="adr" name="address" placeholder="Street Address" required> 
							<label for="city"><i class="fa fa-institution"></i> City</label> 
							<input type="text" id="city" name="city" placeholder="City" required>

							<div class="row">
								<div class="col-50">
									<label for="state">State</label> <input type="text" id="state"
										name="state" placeholder="State" required>
								</div>
								<div class="col-50">
									<label for="zip">Zip Code</label> <input type="text" id="zip"
										name="zip" placeholder="Zip" required>
								</div>
							</div>
						</div>

						<div class="col-50">
							<h3>Payment</h3>
							<label for="fname">Accepted Cards</label>
							<div class="icon-container">
								<i class="fa fa-cc-visa" style="color: navy;"></i> <i
									class="fa fa-cc-amex" style="color: blue;"></i> <i
									class="fa fa-cc-mastercard" style="color: red;"></i> <i
									class="fa fa-cc-discover" style="color: orange;"></i>
							</div>
							<label for="cname">Name on Card</label> <input type="text"
								id="cname" name="cardname" placeholder="Full Name" required>
							<label for="ccnum">Credit card number</label> <input type="text"
								id="ccnum" name="cardnumber" placeholder="1111-2222-3333-4444" required>
							<label for="expmonth">Exp Month</label> <input type="text"
								id="expmonth" name="expmonth" placeholder="September" required>
							<div class="row">
								<div class="col-50">
									<label for="expyear">Exp Year</label> <input type="text"
										id="expyear" name="expyear" placeholder="2018" required>
								</div>
								<div class="col-50">
									<label for="cvv">CVV</label> <input type="password" id="cvv"
										name="cvv" placeholder="352" required>
								</div>
							</div>
						</div>
					</div>
					<input type="submit" value="Continue to checkout" class="btn">
				</form>
			</div>
		</div>
		<div class="col-25">
			<div class="container">
					<%
							CartHandler cartHandler = new CartHandler();
	 						String cusID = (String)request.getSession().getAttribute("cusID");
							
							Cart cart = cartHandler.getCartbyCustomerIdtwo(cusID);
									
					%>
								<!-- shopping cart contents -->
			
				<h4>
					Cart <span class="price" style="color: black"><i
						class="fa fa-shopping-cart"></i></span>
				</h4>
				<% 
					for (int i = 0; i < cart.getSize(); i++){
						out.println("<p>");
						out.println("<a href=\"#\">");
						out.println(cart.getCartItems().get(i).getItemName());
						out.println("</a>");
						out.println("<span class=\"price\">");
						out.println("$" + cart.getItemTotal(cart.getCartItems().get(i)));
						out.println("</span");
						out.println("</p>");
					}
				
				%>
				<hr>
				<p>
					Total <span class="price" style="color: black">
					<b>
						<%
 								double sum = 0.0;
 								for (int i = 0; i < cart.getSize(); i++) {
 								sum += cart.getItemTotal(cart.getCartItems().get(i));
 								}
 								out.println("$" + sum);
 						%>
					</b></span>
				</p>
			</div>
		</div>
	</div>

</body>
</html>