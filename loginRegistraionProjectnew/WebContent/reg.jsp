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
<link rel='stylesheet' type='text/css' href="css/ereg.css">
<script type="text/javascript" src="js/ereg.js"></script>

</head>
<body>
	<%@ include file="header.jsp"%>
	<div class="container">
		<h1 class="well" style="padding-top: 40;">Registration Form</h1>
		<div class="col-lg-12 well">
			<div class="row">
				<form action="reg" method="post" name='registration'
					onsubmit="return validateempreg1();">
					<div class="col-sm-12">
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>First Name</label> <input type="text" name="fname"
									placeholder="Enter First Name Here.." class="form-control"
									onblur="name1()" id="fnm">
								<p id="p1"></p>
							</div>
							<div class="col-sm-6 form-group">
								<label>Last Name</label> <input type="text" name="lname"
									placeholder="Enter Last Name Here.." class="form-control"
									onblur="name2()" id="lnm">
								<p id="p2"></p>
							</div>
						</div>
						<div class="form-group">
							<label>Address</label>
							<textarea placeholder="Enter Address Here.." rows="3" name="add"
								class="form-control" onblur="address()" id="ad1"></textarea>
							<p id="p3"></p>
						</div>

						<div class="row">

							<div class="col-sm-6 form-group">
								<label>Company</label> <input type="text" name="comp_name"
									placeholder="Enter Company Name Here.." class="form-control"
									onblur="comp()" id="cmp">
								<p id="p4"></p>
							</div>
							<div class="col-sm-6 form-group">
								<label>Salary</label> <input type="text" name="sal"
									placeholder="Enter salary Here.." class="form-control">
								<p id="p5"></p>
							</div>
						</div>
						<div class="form-group">
							<label>Phone Number</label> <input type="text" name="contact"
								placeholder="Enter Phone Number Here.." class="form-control"
								onblur="phone()" id="pnum">
							<p id="p6"></p>
						</div>
						<div class="form-group">
							<label>Email Address</label> <input type="text" name="email"
								placeholder="Enter Email Address Here.." class="form-control"
								onblur="email1()" id="usremail">
							<p id="p7"></p>
						</div>


						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Age</label> <input type="text" name="age"
									placeholder="Enter age Here.." class="form-control"
									onblur="age1()" id="agelimit">
								<p id="p8"></p>
							</div>
							<div class="col-sm-6 form-group">
								<label>Specialized</label>
								<li><select name="specialize" onblur="special()" id="spl"
									style="color: black; font-size: 20px; width: 65%; height: 34px; padding-left: 10px; font-family: sans-serif;">
										<option selected="" value="Default"
											style="color: blue; font-size: 16px;"><em>Select</em></option>
										<option value="java">java</option>
										<option value="sql">sql</option>
										<option value="dotnet">dotnet</option>
										<option value="android">android</option>
										<option value="angular">angular</option>
										<option value="ios">ios</option>
								</select></li>
								<p id="p9"></p>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6 form-group">
								<label>Gender</label> <br> <input type="radio"
									name="gender" value="male" id="male1"
									onblur="gender_validation(id)"><label for="male">Male</label><br>
								<input type="radio" name="gender" value="female" id="female1"
									onblur="gender_validation(id)"><label for="female">female</label><br>
								<input type="radio" name="gender" value="other" id="other1"
									onblur="gender_validation(id)"><label for="other">other</label>
								<p id="p10"></p>
							</div>
							<div class="col-sm-6 form-group">
								<label>Languages Known</label>
								<!-- <br> <input type="checkbox"
									name="lang_known" value="hindi" /><label for="hindi">hindi</label><br>
								<input type="checkbox" name="lang_known" value="english" /><label
									for="english">english</label><br> <input type="checkbox"
									name="lang_known" value="marathi" /><label for="marathi">marathi</label><br>
								<input type="checkbox" name="lang_known" value="kannada" /><label
									for="kannada">kannada</label><br> <input type="checkbox"
									name="lang_known" value="gujrathi" /><label for="gujrathi">gujrathi</label><br>
								<input type="checkbox" name="lang_known" value="tamil" /><label
									for="tamil">tamil</label> -->

								<li><select name="lang_known" onblur="lang_validation()"
									id="lang1" size="5" multiple="multiple"
									style="color: black; width: 65%; font-size: 16px; height: 120px; padding-left: 10px; font-family: sans-serif;">
										<option selected="" value="Default"
											style="color: blue; font-size: 20px;"><em>Select</em></option>
										<option value="English">English</option>
										<option value="Hindi">Hindi</option>
										<option value="Marathi">Marathi</option>
										<option value="Kannada">Kannada</option>
										<option value="Gujrathi">Gujrathi</option>
										<option value="Tamil">Tamil</option>
								</select></li>
								<p id="p11"></p>
							</div>
						</div>

						<input type="submit" value="Register" id="sub">
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>





