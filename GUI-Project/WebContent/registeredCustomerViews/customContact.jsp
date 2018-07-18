<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Contact Us</title>
</head>
<head>
<meta name="author" content="Erwin Herrera">
<meta name="viewport" content="width=device-width, initial-scale=1">
<style type="text/css">
body {
	font-family: Arial, Helvetica, sans-serif;
}

input[type=text], select, textarea {
	width: 100%;
	padding: 12px;
	border: 1px solid #ccc;
	border-radius: 4px;
	box-sizing: border-box;
	margin-top: 6px;
	margin-bottom: 16px;
	resize: vertical;
}

input[type=submit] {
	background-color: #4CAF50;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}

input[type=submit]:hover {
	background-color: #45a049;
}

.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
</style>
</head>
<body>

	<a href="./signedInCusWebsite.jsp"><font color="000000">Back to Homepage</font></a>
	<h1>Contact Us</h1>

<form action="ContactUsConfirmServlet" method="GET">

	<div class="container">
			<label for="fname">First Name</label> <input type="text" id="fname"
				name="firstname" placeholder="First Name" required> <label
				for="lname">Last Name</label> <input type="text" id="lname"
				name="lastname" placeholder="Last Name" required> <label for="lname">Email
				Address</label> <input type="text" id="email" name="email"
				placeholder="Email Address"> <label for="subject">Subject</label>
			<textarea id="subject" name="subject" placeholder="Write something.."
				style="height: 200px" cols="" rows=""></textarea>

			<input type="submit" value="Submit">
	</div>
	</form>
	

</body>
</html>