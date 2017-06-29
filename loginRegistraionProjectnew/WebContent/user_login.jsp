<html lang="en">
<head>
<title>user login</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel='stylesheet' type='text/css' href='css/login.css'>
<script type="text/javascript" src="js/login.js"></script>
<script>
	
</script>
</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-lg-4 col-md-3"></div>
			<div class="col-lg-4 col-md-6 col-sm-12 col-xs-12">
				<div class="form">
					<form action="user_login" method="post" name='registration'
						id="ex1" onsubmit="return validateuserlogin()">
						<div>
							<h3 align="center">&nbsp Login Here..</h3>
						</div>
						<div class="form-group">
							<label for="usr">&nbsp User Email</label> <input type="text"
								class="form-control" id="usr" name="uemail" placeholder="Email"
								style="background: #f2f2f2;" onblur="email()">
							<p id="p1"></p>
						</div>
						<div class="form-group">
							<label for="pwd">&nbsp Password </label> <input type="password"
								class="form-control" id="pwd" name="pass" placeholder="Password"
								style="background: #f2f2f2;" onblur="pass1()">
							<p id="p2"></p>
						</div>
						<div>
							<%
								HttpSession session1 = request.getSession();
								String msg = (String) session1.getAttribute("msg");

								if (msg != null) {
							%>
							<p style='font-style: verdana; color: red'>Invalid
								credential...</p>
							<%
								}
							%>
						</div>

						<div class="form-group">
							<input type="submit" value="Login" id="sub">
						</div>
						<p class="message">
							Not registered? <a href="user_reg">Create an account</a>
						</p>

					</form>
				</div>
			</div>
			<div class="col-lg-4 col-md-3"></div>
		</div>
	</div>
</body>
</html>