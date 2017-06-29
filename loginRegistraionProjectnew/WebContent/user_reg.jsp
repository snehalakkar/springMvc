<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel='stylesheet' type='text/css' href='css/login.css'>
<script type="text/javascript" src="js/login.js"></script>  
<script>
	$('.message a').click(function() {
		$('form').animate({
			height : "toggle",
			opacity : "toggle"
		}, "slow");
	});
</script>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="container">
<div class="row">
<div class="col-lg-4 col-md-3"></div>
<div class="col-lg-4 col-md-6 col-sm-12 col-xs-12">
<div class="form">
<form action="user_reg" method="post" name='registration'
			 id="ex1" onsubmit="return validateuserreg()">
<div><h3 align="center">&nbsp Register Here..</h3></div>
	<div class="form-group" >
      <label for="usr">&nbsp  User Id</label>
      <input type="number" class="form-control" id="usrid"  name="UserId" placeholder="User Id" onblur="id1()">
	<p id="p3"></p>
    </div>
	<div class="form-group" >
      <label for="usr">&nbsp  User Name</label>
     <input type="text" class="form-control" id="usrname" name="Username" placeholder="User Name" onblur="name1()">
	<p id="p4"></p>
    </div>

    <div class="form-group" >
      <label for="usr">&nbsp  User Email</label>
      <input type="text" class="form-control" id="usr" name="UserMail" placeholder="Email" onblur="email()">
	<p id="p1"></p>
    </div>
    <div class="form-group">
      <label for="pwd">&nbsp Password </label>
      <input type="password" class="form-control" id="pwd" name="UserPass"placeholder="Password"  onblur="pass1()">
    <p id="p2"></p>
    </div>

<div class="form-group">
 <input type="submit" value="Register" id="sub">
</div>
<p class="message">Already registered? <a href="user_login">Sign In</a></p>
  </form>
</div>
</div>
<div class="col-lg-4 col-md-3"></div>
</div>
</div>
</body>
</html>