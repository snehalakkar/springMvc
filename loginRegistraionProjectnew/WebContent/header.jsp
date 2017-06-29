<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	
</head>
<body>

	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a
					style="font-family: verdana; color: white; text-shadow: 2px 2px 8px #FF0000;"
					class="navbar-brand" href="#"><em>BridgeLabz</em></a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
				<%
						Integer id = (Integer) session.getAttribute("UserId");
						if (id != null) {
					%>
					<li><a href="reg"> Add Employee</a></li>
					<%} %>
					<%
						Integer id1 = (Integer) session.getAttribute("UserId");
						if (id1 != null) {
					%>
					<li><a href="details"> Display Details</a></li>
					<%} %>
				</ul>
				<ul class="nav navbar-nav navbar-right">
				<%
						Integer id2 = (Integer) session.getAttribute("UserId");
						if (id2 == null) {
					%>
					<li><a href="user_reg"><span
							class="glyphicon glyphicon-user"></span> Sign Up</a></li>
					<%
						}
					%>
					<%
						Integer id3 = (Integer) session.getAttribute("UserId");
						if (id3 != null) {
					%>
					<li><a href="LogoutServlet"><span
							class="glyphicon glyphicon-log-out"></span> LogOut</a></li>
					<%
						}
					%>
				</ul>
			</div>
		</div>
	</nav>
</body>
</html>
